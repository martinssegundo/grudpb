DO $$
BEGIN
    IF NOT EXISTS (
        SELECT 1
        FROM   information_schema.tables
        WHERE  table_schema = 'paciente'
        AND    table_name = 'tb_paciente'
    ) THEN
        CREATE SCHEMA IF NOT EXISTS paciente;
        CREATE TABLE paciente.tb_paciente (
            id SERIAL PRIMARY KEY,
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
        AND    table_name = 'tb_consulta'
    ) THEN
        CREATE TABLE paciente.tb_paciente_consulta (
            paciente_id BIGINT REFERENCES paciente.tb_paciente(id),
            cod_consulta BIGINT,
            PRIMARY KEY (paciente_id, cod_consulta)
        );
    END IF;
END $$;
