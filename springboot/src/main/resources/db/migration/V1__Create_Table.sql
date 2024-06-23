CREATE TABLE IF NOT EXISTS locations (
    id INTEGER,
    location_name VARCHAR(250) NOT NULL,
    longitude NUMERIC(10, 6) NOT NULL,
    latitude NUMERIC(10, 6) NOT NULL,
    PRIMARY KEY (id)
);