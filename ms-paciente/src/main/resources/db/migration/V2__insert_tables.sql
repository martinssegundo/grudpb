-- Inserir pacientes
INSERT INTO paciente.tb_paciente (ds_nome, num_idade) VALUES
  ('Luiz Segundo', 30),
  ('Maria Silva', 25),
  ('João Oliveira', 40),
  ('Ana Santos', 35),
  ('Pedro Costa', 28),
  ('Carla Pereira', 33),
  ('Rafaela Ferreira', 27),
  ('Bruno Souza', 38),
  ('Fernanda Almeida', 32),
  ('Lucas Carvalho', 29);

-- Inserir consultas para os pacientes
INSERT INTO paciente.tb_paciente_consulta (paciente_id, cod_consulta) VALUES
  -- Paciente Luiz Segundo - 3 consultas
  ((SELECT id FROM paciente.tb_paciente WHERE ds_nome = 'Luiz Segundo'), 1),
  ((SELECT id FROM paciente.tb_paciente WHERE ds_nome = 'Luiz Segundo'), 2),
  ((SELECT id FROM paciente.tb_paciente WHERE ds_nome = 'Luiz Segundo'), 3),

  -- Paciente Maria Silva - 2 consultas
  ((SELECT id FROM paciente.tb_paciente WHERE ds_nome = 'Maria Silva'), 1),
  ((SELECT id FROM paciente.tb_paciente WHERE ds_nome = 'Maria Silva'), 2),

  -- Paciente João Oliveira - 4 consultas
  ((SELECT id FROM paciente.tb_paciente WHERE ds_nome = 'João Oliveira'), 1),
  ((SELECT id FROM paciente.tb_paciente WHERE ds_nome = 'João Oliveira'), 2),
  ((SELECT id FROM paciente.tb_paciente WHERE ds_nome = 'João Oliveira'), 3),
  ((SELECT id FROM paciente.tb_paciente WHERE ds_nome = 'João Oliveira'), 4),

  -- Paciente Ana Santos - 1 consulta
  ((SELECT id FROM paciente.tb_paciente WHERE ds_nome = 'Ana Santos'), 1),

  -- Paciente Pedro Costa - 5 consultas
  ((SELECT id FROM paciente.tb_paciente WHERE ds_nome = 'Pedro Costa'), 1),
  ((SELECT id FROM paciente.tb_paciente WHERE ds_nome = 'Pedro Costa'), 2),
  ((SELECT id FROM paciente.tb_paciente WHERE ds_nome = 'Pedro Costa'), 3),
  ((SELECT id FROM paciente.tb_paciente WHERE ds_nome = 'Pedro Costa'), 4),
  ((SELECT id FROM paciente.tb_paciente WHERE ds_nome = 'Pedro Costa'), 5),

  -- Paciente Carla Pereira - 2 consultas
  ((SELECT id FROM paciente.tb_paciente WHERE ds_nome = 'Carla Pereira'), 1),
  ((SELECT id FROM paciente.tb_paciente WHERE ds_nome = 'Carla Pereira'), 2),

  -- Paciente Rafaela Ferreira - 3 consultas
  ((SELECT id FROM paciente.tb_paciente WHERE ds_nome = 'Rafaela Ferreira'), 1),
  ((SELECT id FROM paciente.tb_paciente WHERE ds_nome = 'Rafaela Ferreira'), 2),
  ((SELECT id FROM paciente.tb_paciente WHERE ds_nome = 'Rafaela Ferreira'), 3),

  -- Paciente Bruno Souza - 1 consulta
  ((SELECT id FROM paciente.tb_paciente WHERE ds_nome = 'Bruno Souza'), 1),

  -- Paciente Fernanda Almeida - 4 consultas
  ((SELECT id FROM paciente.tb_paciente WHERE ds_nome = 'Fernanda Almeida'), 1),
  ((SELECT id FROM paciente.tb_paciente WHERE ds_nome = 'Fernanda Almeida'), 2),
  ((SELECT id FROM paciente.tb_paciente WHERE ds_nome = 'Fernanda Almeida'), 3),
  ((SELECT id FROM paciente.tb_paciente WHERE ds_nome = 'Fernanda Almeida'), 4),

  -- Paciente Lucas Carvalho - 2 consultas
  ((SELECT id FROM paciente.tb_paciente WHERE ds_nome = 'Lucas Carvalho'), 1),
  ((SELECT id FROM paciente.tb_paciente WHERE ds_nome = 'Lucas Carvalho'), 2);
