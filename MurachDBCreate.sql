/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  eric
 * Created: 2018. 11. 14
 */

CONNECT 'jdbc:derby:MurachDB;create=true';

create table Products 
    (
        ProductCode varchar(10),
        Description varchar(40),
        Price double
    );

insert into Products values
('bvbn', 'Visual Basic', 49.50);
insert into Products values
('java', 'Java', 49.50);
insert into Products values
('cshp', 'C sharp', 40.50);
insert into Products values
('mcb2', 'MainFrame COBOL Basic', 49.50);
insert into Products values
('jsps', 'Java suvelets and jsp', 49.50);
insert into Products values
('zjc1', 'OS 390 and zOS', 49.50);

select * from products;