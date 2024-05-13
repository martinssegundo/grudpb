DO $$
BEGIN
    IF NOT EXISTS (
        SELECT 1
        FROM   information_schema.schemata
        WHERE  schema_name = 'paciente'
    ) THEN
        CREATE SCHEMA paciente;
    END IF;
END $$;

DO $$
BEGIN
    IF NOT EXISTS (
        SELECT 1
        FROM   information_schema.sequences
        WHERE  sequence_schema = 'public'
        AND    sequence_name = 'paciente_sequence'
    ) THEN
        CREATE SEQUENCE paciente_sequence START 1;
    END IF;
END $$;


DO $$
BEGIN
    IF NOT EXISTS (
        SELECT 1
        FROM   information_schema.tables
        WHERE  table_schema = 'paciente'
        AND    table_name = 'tb_paciente'
    ) THEN
        CREATE TABLE paciente.tb_paciente (
            id BIGINT PRIMARY KEY DEFAULT nextval('paciente_sequence'),
            ds_nome VARCHAR(255),
            num_idade BIGINT
        );
    END IF;
END $$;

DO $$
BEGIN
    IF NOT EXISTS (
        SELECT 1
        FROM   information_schema.tables
        WHERE  table_schema = 'paciente'
        AND    table_name = 'tb_paciente_consulta'
    ) THEN
        CREATE TABLE paciente.tb_paciente_consulta (
            paciente_id BIGINT REFERENCES paciente.tb_paciente(id),
            cod_consulta BIGINT,
            PRIMARY KEY (paciente_id, cod_consulta)
        );
    END IF;
END $$;
