CREATE TABLE patients
(
    id           SERIAL PRIMARY KEY,
    name         VARCHAR(150) NOT NULL,
    age          INTEGER      NOT NULL,
    urgency      VARCHAR(20)  NOT NULL,
    arrival_time TIME         NOT NULL,
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE triage_queue
(
    id             SERIAL PRIMARY KEY,
    patient_id     INTEGER NOT NULL,
    priority       INTEGER NOT NULL,
    queue_position INTEGER,
    created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (patient_id) REFERENCES patients (id)
);