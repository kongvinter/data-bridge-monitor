CREATE TABLE IF NOT EXISTS raw_records (
    id SERIAL PRIMARY KEY,
    content TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE OR REPLACE FUNCTION notify_event() RETURNS TRIGGER AS $$
BEGIN
  PERFORM pg_notify('new_event_channel', row_to_json(NEW)::text);
  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

DROP TRIGGER IF EXISTS trg_bridge_event ON raw_records;
CREATE TRIGGER trg_bridge_event
AFTER INSERT ON raw_records
FOR EACH ROW EXECUTE FUNCTION notify_event();
