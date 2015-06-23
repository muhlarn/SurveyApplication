BEGIN;

--CREATE SEQUENCE serial_id_seq START 1;


CREATE TABLE surveyparticipant (
    id SERIAL, 
    firstname       varchar(40),
   	lastname       varchar(40),
    age         int4,
    CONSTRAINT id_surveyparticipant_pk PRIMARY KEY(id)
);


CREATE TABLE location (
    id SERIAL, 
    latitude       float8,
   	longitude      float8,
    CONSTRAINT id_location_pk PRIMARY KEY(id)
);


CREATE TABLE questiontype (
    id SERIAL, 
    q_type_text  varchar(40),
    CONSTRAINT id_questiontype_pk PRIMARY KEY(id)
);


CREATE TABLE question (
    id SERIAL, 
    q_text       varchar(40),
   	q_type_fk      INT4 REFERENCES questiontype,
    CONSTRAINT id_question_pk PRIMARY KEY(id)
);


CREATE TABLE survey(
		id SERIAL, 
		name VARCHAR(32), 
		version INT4,
		location_fk INT4 REFERENCES location,
		surveyor_fk INT4 REFERENCES  surveyparticipant,
		respondent_fk INT4 REFERENCES  surveyparticipant,
		question_fk INT4 REFERENCES question,
		surveystatus_fk INT4,
		creationdate date,
		CONSTRAINT id_survey_pk PRIMARY KEY(id)
);

COMMIT;
