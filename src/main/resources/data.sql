CREATE TABLE IF NOT EXISTS courier (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    last_latitude DOUBLE DEFAULT 0,
    last_longitude DOUBLE DEFAULT 0,
    total_distance DOUBLE NULL
);

INSERT INTO courier (last_latitude, last_longitude, total_distance) VALUES (0, 0, NULL);
INSERT INTO courier (last_latitude, last_longitude, total_distance) VALUES (0, 0, NULL);
INSERT INTO courier (last_latitude, last_longitude, total_distance) VALUES (0, 0, NULL);
INSERT INTO courier (last_latitude, last_longitude, total_distance) VALUES (0, 0, NULL);
INSERT INTO courier (last_latitude, last_longitude, total_distance) VALUES (0, 0, NULL);
