INSERT INTO college (id, name, name_of_city) VALUES (1, 'University of California', 'Berkeley') ON CONFLICT (id) DO NOTHING;
INSERT INTO college (id, name, name_of_city) VALUES (2, 'Harvard University', 'Cambridge') ON CONFLICT (id) DO NOTHING;

INSERT INTO student (id, name, address, college_id) VALUES (1, 'Mark', 'Telegraph Ave', 1) ON CONFLICT (id) DO NOTHING;
INSERT INTO student (id, name, address, college_id) VALUES (2, 'Susie', 'Shattuck Ave', 1) ON CONFLICT (id) DO NOTHING;
INSERT INTO student (id, name, address, college_id) VALUES (3, 'Valerie', 'Euclid Ave', 1) ON CONFLICT (id) DO NOTHING;
INSERT INTO student (id, name, address, college_id) VALUES (4, 'John', 'Oxford St', 2) ON CONFLICT (id) DO NOTHING;
INSERT INTO student (id, name, address, college_id) VALUES (5, 'Mary', 'Washington St', 2) ON CONFLICT (id) DO NOTHING;
INSERT INTO student (id, name, address, college_id) VALUES (6, 'Joseph', 'Everett St', 2) ON CONFLICT (id) DO NOTHING;

INSERT INTO book (id, title, author, isbn)
VALUES (1, 'Computer Science: A Concise Introduction', 'Ian Sinclair', '978-0750602525') ON CONFLICT (id) DO NOTHING;
INSERT INTO book (id, title, author, isbn)
VALUES (2, 'Computer Science Handbook 2nd Edition', 'Allen B. Tucker', '978-1584883609') ON CONFLICT (id) DO NOTHING;
INSERT INTO book (id, title, author, isbn)
VALUES (3, 'The Code Book: The Secret History of Code-Breaking', 'Simon Singh', '978-1857028898') ON CONFLICT (id) DO NOTHING;
INSERT INTO book (id, title, author, isbn)
VALUES (4, 'Chaos: Making A New Science', 'James Gleick', '978-0749386061') ON CONFLICT (id) DO NOTHING;
