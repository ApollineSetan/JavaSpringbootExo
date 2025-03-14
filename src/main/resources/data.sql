-- Création de la table
CREATE TABLE livre (
    id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    titre VARCHAR(50) UNIQUE NOT NULL,
    description VARCHAR(255) NOT NULL,
    date_publication DATE NOT NULL,
    genre VARCHAR(50),
    auteur VARCHAR(50),
    maison_edition VARCHAR(50)
);

-- Ajout d'enregistrements
INSERT INTO livre (titre, description, date_publication, genre, auteur, maison_edition) VALUES
    ('Candide', 'Description de Candide', '1759-01-01', 'satire', 'Voltaire', 'Flammarion'),
    ('Le Meilleur des Mondes', 'Description de Le Meilleur des Mondes', '1932-02-04', 'distopie', 'Aldous Huxley', 'Chatto & Windus');