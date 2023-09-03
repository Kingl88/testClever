insert into banks (name)
values ('Clever Bank'),
       ('Some Bank'),
       ('First Bank'),
       ('Second Bank'),
       ('Best Bank');
insert into users (name, surname, lastname)
values ('Александр', 'Алексеевич', 'Иванов'),
       ('Алексей', 'Арсениевич', 'Смирнов'),
       ('Альберт', 'Артурович', 'Кузнецов'),
       ('Андрей', 'Борисович', 'Попов'),
       ('Антон', 'Васильевич', 'Васильев'),
       ('Вадим', 'Викторович', 'Федосов'),
       ('Виктор', 'Витальевич', 'Корольков'),
       ('Владислав', 'Владимирович', 'Звягинцев'),
       ('Дмитрий', 'Геннадьевич', 'Елизаров'),
       ('Евгений', 'Георгиевич', 'Грибов'),
       ('Илья', 'Димитриевич', 'Калачев'),
       ('Кирилл', 'Евгеньевич', 'Кукушкин'),
       ('Константин', 'Егорович', 'Судаков'),
       ('Максим', 'Ефимович', 'Рябинин'),
       ('Михаил', 'Захарович', 'Поликарпов'),
       ('Никита', 'Игоревич', 'Моргунов'),
       ('Олег', 'Иванович', 'Злобин'),
       ('Павел', 'Константинович', 'Гладков'),
       ('Сергей', 'Львович', 'Снегирев'),
       ('Станислав', 'Львович', 'Раков'),
       ('Эдуард', 'Максимович', 'Муратов'),
       ('Юрий', 'Михайлович', 'Безруков'),
       ('Ярослав', 'Олегович', 'Уваров');
insert into banks_users(bank_id, user_id)
values (1, 2),
       (1, 4),
       (1, 6),
       (1, 8),
       (1, 10),
       (1, 12),
       (1, 14),
       (2, 1),
       (2, 3),
       (2, 9),
       (2, 11),
       (2, 13),
       (2, 15),
       (2, 17),
       (3, 16),
       (3, 18),
       (3, 20),
       (3, 22),
       (3, 19),
       (3, 21),
       (3, 5),
       (4, 7),
       (4, 12),
       (4, 5),
       (4, 18),
       (4, 20),
       (4, 17),
       (4, 10),
       (5, 3),
       (5, 9),
       (5, 2),
       (5, 11),
       (5, 16),
       (5, 19),
       (5, 5),
       (5, 23);
insert into accounts (number_iban, number, bank_id, user_id, balance, currency_type)
values ('AE070331234567890123456', '40759537900000008573', 1, 2, 5149.96, 'RUB'),
       ('AL47212110090000000235698741', '40702810288606135698', 1, 4, 1260.70, 'BYN'),
       ('AT611904300234573201', '40702810646741167668', 1, 6, 2903.97, 'USD'),
       ('AZ21NABZ00000000137010001944', '40702810168292906678', 1, 8, 8750.60, 'EUR'),
       ('BA391290079401028494', '40702810394776906625', 1, 10, 3930.48, 'RUB'),
       ('BE68539007547034', '40702810523407392557', 1, 12, 8427.98, 'BYN'),
       ('BG80BNBG96611020345678', '40702810889268626915', 1, 14, 7979.94, 'USD'),
       ('BH67BMAG00001299123456', '40702810645571454416', 2, 1, 4799.80, 'EUR'),
       ('BR1800360305000010009795493C1', '40702810861655212099', 2, 3, 3435.89, 'RUB'),
       ('BY13NBRB3600900000002Z00AB00', '40702810594664551092', 2, 9, 8114.61, 'BYN'),
       ('CH9300762011623852957', '40702810915952155970', 2, 11, 9678.16, 'USD'),
       ('CR05015202001026284066', '40702810555754621703', 2, 13, 8725.51, 'EUR'),
       ('CY17002001280000001200527600', '40702810429169212875', 2, 15, 8725.51, 'RUB'),
       ('CZ6508000000192000145399', '40702810443127890419', 2, 17, 3450.62, 'BYN'),
       ('DE89370400440532013000', '40702810856038888343', 3, 16, 3046.94, 'USD'),
       ('DK5000400440116243', '40702810761968196229', 3, 18, 3640.29, 'EUR'),
       ('DO28BAGR00000001212453611324', '40702810139504379443', 3, 20, 4122.60, 'RUB'),
       ('EE382200221020145685', '40702810882542643190', 3, 22, 5611.99, 'BYN'),
       ('ES9121000418450200051332', '40702810281290291644', 3, 19, 5611.99, 'USD'),
       ('FI2112345600000785', '40702810053359919626', 3, 21, 2865.77, 'EUR'),
       ('FO6264600001631634', '40702810922875551974', 3, 5, 2016.40, 'RUB'),
       ('FR1420041010050500013M02606', '40702810113499052105', 4, 7, 9494.62, 'BYN'),
       ('GB29NWBK60161331926819', '40702810933834139193', 4, 12, 6721.31, 'USD'),
       ('GE29NB0000000101904917', '40702810873488995814', 4, 5, 6426.89, 'EUR'),
       ('GI75NWBK000000007099453', '40702810185118978051', 4, 18, 4064.52, 'RUB'),
       ('GL8964710001000206', '40702810733015007448', 4, 20, 2373.17, 'BYN'),
       ('GR1601101250000000012300695', '40702810394776906625', 4, 17, 3442.36, 'USD'),
       ('GT82TRAJ01020000001210029690', '40702810041375359256', 4, 10, 1554.44, 'EUR'),
       ('HR1210010051863000160', '40702810236807780205', 5, 3, 9898.85, 'RUB'),
       ('HU42117730161111101800000000', '40702810685829554154', 5, 9, 1320.27, 'BYN'),
       ('IE29AIBK93115212345678', '40702810015003156346', 5, 2, 4298.92, 'USD'),
       ('IL620108000000099999999', '40702810232237716733', 5, 11, 4298.92, 'EUR'),
       ('IQ98NBIQ850123456789012', '40702810733134688447', 5, 16, 992.82, 'RUB'),
       ('IS140159260076545510730339', '40702810494395672900', 5, 19, 5020.15, 'BYN'),
       ('IT60X0542811101000000123456', '40702810095432785955', 5, 5, 7206.20, 'USD'),
       ('JO94CBJO0010000000000131000302', '40702810912504209853', 5, 5, 2925.19, 'EUR'),
       ('KW81CBKU0000000000001234560101', '40702810125992019044', 5, 19, 3297.06, 'RUB'),
       ('KZ86125KZT5004100100', '40702810916380253964', 5, 16, 6733.57, 'BYN'),
       ('LB62099900000001001901229114', '40702810680375321519', 4, 10, 2499.65, 'USD'),
       ('LC55HEMM000100010012001200023015', '40702810137774878954', 4, 17, 7207.01, 'EUR'),
       ('LI21088100002324013AA', '40702810879327752589', 4, 18, 4430.40, 'RUB'),
       ('LT121000011101001000', '40702810399617543645', 3, 21, 8325.06, 'BYN'),
       ('LT121000011101001000', '40702810921177670426', 3, 16, 4844.89, 'USD'),
       ('LT121000011101001000', '40702810167151431872', 3, 22, 4027.22, 'EUR'),
       ('MC5811222000010123456789030', '40702810056596863886', 2, 1, 9823.14, 'RUB'),
       ('MC5811222000010123456789030', '40702810056596863886', 2, 23, 8935.46, 'BYN');