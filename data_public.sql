INSERT INTO users (id, email, name, display_name, password) VALUES (1, 'admin@ttrpg-balls.com', 'admin', 'admin', '$2a$10$hiIQcqTYSGKu4eyHfFSOzufDqKLTQlku/OqBcs/5Nv8VQm9jI2S/a'),
                                                                   (2, 'olter@gttrpg-balls.com', 'olteR', 'olteR', '$2a$10$EHSaFaO4nljzREqLn4kz8Ol82HirKPBX7VUeQ1P1lUAQIkp.1RECe'),
                                                                   (3, 'rero@ttrpg-balls.com', 'rero', 'rero', '$2a$10$kaE5D.T0I7fn6j1mIhWPF.O5Tk/EsE2ayqSRbBcp2WB36nPcf0Yru'),
                                                                   (4, 'geri@ttrpg-balls.com', 'Geri', 'Geri', '$2a$10$jZsluxkAuRaZvoZyWB/MNO/j2iiQye/KGiH2zNfRckq/yOa6pH5m.'),
                                                                   (5, 'marci@ttrpg-balls.com', 'Marci', 'Marci', '$2a$10$tdw06E/BpPfwMAvNhzVy1O5vmP.n8E3iVphkV8UG3yKkZmsG.8u.S'),
                                                                   (6, 'tiniky@ttrpg-balls.com', 'Tiniky', 'Tiniky', '$2a$10$yPtASJuJQfVNVmdkg8547.7B4MYZ4zDi.aaNLCCVScI6YDRj1Wtxq'),
                                                                   (7, 'ogike@ttrpg-balls.com', 'ogike', 'ogike', '$2a$10$ZDY9MGgRwl9fdXHyUM/y3OZDQ7ZFTI2m/ViJxNd7gHcx7oyU7UKY.');
INSERT INTO rulesets (id, core_dice, name, short_name) VALUES (8, 20, 'Dungeons & Dragons 5E', 'dnd5e'),
                                                              (9, 20, 'Pathfinder 2E', 'pf2e');
INSERT INTO campaigns (id, name, game_master_id, ruleset_id) VALUES (10, 'D&VE', 4, 8),
                                                                    (11, 'not dave', 5, 8),
                                                                    (12, 'C4RL', 2, 8);
INSERT INTO characters (id, name, owner_id, ruleset_id) VALUES (13, 'Rakash', 5, 8),
                                                               (14, 'Rico', 7, 8),
                                                               (15, 'SPADE', 3, 8),
                                                               (16, 'Sisylla', 2, 8),
                                                               (17, 'Corvus', 3, 8),
                                                               (18, 'Kian', 7, 8),
                                                               (19, 'Luna', 4, 8),
                                                               (20, 'Noxua', 2, 8),
                                                               (21, 'Elise', 5, 8),
                                                               (22, 'Fence', 4, 8),
                                                               (23, 'Lex', 3, 8),
                                                               (24, 'Rowern', 6, 8);
INSERT INTO campaign_characters (campaign_id, character_id) VALUES (10, 13), (10, 14), (10, 15), (10, 16),
                                                                   (11, 17), (11, 18), (11, 19), (11, 20),
                                                                   (12, 21), (12, 22), (12, 23), (12, 24);
