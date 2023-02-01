INSERT INTO users (id, email, name, display_name, password) VALUES (1, 'admin@ttrpg-balls.com', 'admin', 'admin', '$2a$10$hiIQcqTYSGKu4eyHfFSOzufDqKLTQlku/OqBcs/5Nv8VQm9jI2S/a'),
                                                                   (2, 'olter@ttrpg-balls.com', 'olteR', 'olteR', '$2a$10$EHSaFaO4nljzREqLn4kz8Ol82HirKPBX7VUeQ1P1lUAQIkp.1RECe'),
                                                                   (3, 'rero@ttrpg-balls.com', 'rero', 'rero', '$2a$10$kaE5D.T0I7fn6j1mIhWPF.O5Tk/EsE2ayqSRbBcp2WB36nPcf0Yru'),
                                                                   (4, 'geri@ttrpg-balls.com', 'Geri', 'Geri', '$2a$10$jZsluxkAuRaZvoZyWB/MNO/j2iiQye/KGiH2zNfRckq/yOa6pH5m.'),
                                                                   (5, 'marci@ttrpg-balls.com', 'Marci', 'Marci', '$2a$10$tdw06E/BpPfwMAvNhzVy1O5vmP.n8E3iVphkV8UG3yKkZmsG.8u.S'),
                                                                   (6, 'tiniky@ttrpg-balls.com', 'Tiniky', 'Tiniky', '$2a$10$yPtASJuJQfVNVmdkg8547.7B4MYZ4zDi.aaNLCCVScI6YDRj1Wtxq'),
                                                                   (7, 'ogike@ttrpg-balls.com', 'ogike', 'ogike', '$2a$10$ZDY9MGgRwl9fdXHyUM/y3OZDQ7ZFTI2m/ViJxNd7gHcx7oyU7UKY.');
INSERT INTO campaigns (id, name, description) VALUES (11000, 'D&VE', 'geri dying'), (11001, 'not dave', 'currently strixhaven 2 electric boogaloo'), (11002, 'C4RL', 'the raven is a lie');
INSERT INTO characters (id, name, owner_id) VALUES (12000, 'Rakash', 10003), (12001, 'Rico', 10005), (12002, 'SPADE', 10001), (12003, 'Sisylla', 10000),
                                                   (12004, 'Corvus', 10001), (12005, 'Kian', 10005), (12006, 'Luna', 10002), (12006, 'Noxua', 10000),
                                                   (12007, 'Elise', 10003), (12008, 'Fence', 10002), (12009, 'Lex', 10001), (12010, 'Rowern', 10004);
INSERT INTO campaign_users (id, role, campaign_id, user_id) VALUES (13000, 'GAME_MASTER', 11000, 10002), (13001, 'PLAYER', 11000, 10000), (13002, 'PLAYER', 11000, 10001), (13003, 'PLAYER', 11000, 10003), (13004, 'PLAYER', 11000, 10005),
                                                                  (13005, 'GAME_MASTER', 11001, 10003), (13006, 'PLAYER', 11001, 10000), (13007, 'PLAYER', 11001, 10001), (13008, 'PLAYER', 11001, 10002), (13009, 'PLAYER', 11001, 10005),
                                                                  (13010, 'GAME_MASTER', 11002, 10000), (13011, 'PLAYER', 11002, 10001), (13012, 'PLAYER', 11002, 10002), (13013, 'PLAYER', 11002, 10003), (13014, 'PLAYER', 11002, 10004);
INSERT INTO campaign_characters (campaign_users_id, character_id) VALUES (13001, 12003), (13002, 12002), (13003, 12000), (13004, 12001),
                                                                        (13006, 12006), (13007, 12004), (13008, 12006), (13009, 12005),
                                                                        (13011, 12009), (13012, 12008), (13013, 12007), (13014, 12010);
INSERT INTO books (id, name, published, short_name) VALUES (14000, 'Core Rulebook', '2019-08-01', 'CRB'), (14001, 'Bestiary', '2019-08-01', 'B1'),
                                                           (14002, 'Gamemastery Guide', '2020-02-26', 'GMG'), (14003, 'Bestiary 2', '2020-05-27', 'B2'),
                                                           (14004, 'Advanced Player''s Guide', '2020-07-30', 'APG'), (14005, 'Bestiary 3', '2021-04-07', 'B3'),
                                                           (14006, 'Secrets of Magic', '2021-09-01', 'SoM'), (14007, 'Guns & Gears', '2021-10-13', 'G&G'),
                                                           (14008, 'Book of the Dead', '2022-04-27', 'BotD'), (14009, 'Dark Archive', '2021-07-27', 'DA');