CREATE TABLE IF NOT EXISTS offers (
  id SERIAL PRIMARY KEY,
  title TEXT,
  discount INT,
  status TEXT,
  created_at TIMESTAMP DEFAULT NOW(),
  updated_at TIMESTAMP DEFAULT NOW()
);
