/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 80019
Source Host           : localhost:3306
Source Database       : fantsy

Target Server Type    : MYSQL
Target Server Version : 80019
File Encoding         : 65001

Date: 2021-12-03 17:11:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ad
-- ----------------------------
DROP TABLE IF EXISTS `ad`;
CREATE TABLE `ad` (
  `gameID` int NOT NULL,
  `AdText` varchar(100) DEFAULT NULL,
  `AdImage` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`gameID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ad
-- ----------------------------
INSERT INTO `ad` VALUES ('1', '最终幻想16;Final Fantasy XVI', 'banner0.jpg');
INSERT INTO `ad` VALUES ('2', '战神;God of War', 'banner1.jpg');
INSERT INTO `ad` VALUES ('3', '孤岛危机;Crysis', 'banner2.jpg');
INSERT INTO `ad` VALUES ('4', '刺客信条;Assassin\'s Creed', 'banner3.jpg');
INSERT INTO `ad` VALUES ('5', '巫师3;The Witcher 3: Wild Hunt', 'banner4.jpg');

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
  `userID` int NOT NULL,
  `gameID` int DEFAULT NULL,
  `count` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`count`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collection
-- ----------------------------
INSERT INTO `collection` VALUES ('100001', '1', '1');
INSERT INTO `collection` VALUES ('100001', '2', '2');
INSERT INTO `collection` VALUES ('100001', '3', '3');
INSERT INTO `collection` VALUES ('100001', '4', '4');
INSERT INTO `collection` VALUES ('100001', '5', '5');
INSERT INTO `collection` VALUES ('100001', '6', '6');
INSERT INTO `collection` VALUES ('100001', '7', '7');
INSERT INTO `collection` VALUES ('100001', '8', '8');

-- ----------------------------
-- Table structure for game
-- ----------------------------
DROP TABLE IF EXISTS `game`;
CREATE TABLE `game` (
  `gameID` int NOT NULL AUTO_INCREMENT,
  `gameImage` varchar(100) DEFAULT NULL,
  `Cname` varchar(100) DEFAULT NULL,
  `Ename` varchar(100) DEFAULT NULL,
  `score` int DEFAULT NULL,
  `developer` varchar(100) DEFAULT NULL,
  `date` varchar(20) DEFAULT NULL,
  `profile` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `category` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`gameID`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of game
-- ----------------------------
INSERT INTO `game` VALUES ('1', 'game1.jpg', '最终幻想 XV', 'Final Fantasy XV', '87', '史克威尔艾尼克斯', '2016-11-29', '《最终幻想XV》以系列共通的新水晶神话为基础，同时展开独立的世界观、使用不同的视觉设计以及角色。游戏主人公诺克提斯·路西斯·凯拉姆是路西斯王国的王子，这个王族保护世界仅存的一颗水晶，并支配一个技术先进的城邦。', '角色扮演');
INSERT INTO `game` VALUES ('2', 'game2.jpg', '战神', 'God of War', '91', '索尼电子娱乐', '2005-03-22', '战神受到了广泛好评，其中GameRankings总分为93.69%，Metacritic总分94分，他们将他们的得分描述为“普遍赞誉”。 美国有线电视新闻网的Tom Lane写道：“战神就是让你记住为什么要玩游戏的游戏类型。 他说，这是上瘾的行动是平衡与少量的拼图和平台元素。 他赞扬它的进展速度，并说这是“市场上最暴力的游戏”之一。', '动作');
INSERT INTO `game` VALUES ('3', 'game3.jpg', '孤岛危机', 'Crysis', '92', 'Crytek Studios', '2007-11-13', '游戏的光影效果给人留下了深刻印象，但是需要硬件足够强硬才能真正享受到这一切。如果不介意画面感受，只是想体验游戏过程，低级别的图像设置可以接受较低的硬件配置，之所以与众不同就是在它优秀的画面，较低品质下的游戏是大打折扣的。游戏附送了编辑器，这对于那些MOD玩家来说无疑是份好礼物。', '动作');
INSERT INTO `game` VALUES ('4', 'game4.jpg', '刺客信条', 'Assassin\'s Creed', '95', '育碧蒙特利尔', '2013-10-29', '《刺客信条4：黑旗》是前几部《刺客信条》系列的集合体，极具带入感的故事背景、强调还原历史的优秀的剧本创作和出色的人物形象塑造让很多玩家十分喜爱。不过碍于主机的机能所限，游戏并没有表现出令人惊艳的画面效果，而在初始剧情讲述方面也存在一些问题让玩家有些摸不到头脑。', '动作');
INSERT INTO `game` VALUES ('5', 'game5.jpg', '巫师3', 'The Witcher 3: Wild Hunt', '99', 'CD Projekt Red、Saber Interactive', '2015-05-19', '《巫师3：狂猎》凭借着庞大的开放世界、精彩的故事、丰富的探索内容与有趣的战斗系统为这段来自波兰的史诗再次谱写出了一段新的篇章。它同时也是CD Projekt Red江湖地位的再次认证，而在当代的游戏界，能够玩得起一线RPG可是一件不小的成就，它就像是地主嘴里的金牙，是身份的象征。', '角色扮演');
INSERT INTO `game` VALUES ('6', 'game6.jpg', '侠盗猎车手5', 'GTA5', '99', 'Rockstar North', '2015-04-14', '《侠盗猎车手5》不仅仅是一部会让你无法自拔的游戏，而且还用聪明犀利的手法讽刺了当代美国社会。在每个角度来讲都是5 年前推出的《侠盗猎车手4》的全面改良，从技术上讲《侠盗猎车手5》用一种十分便捷的方式让游戏更加完善，同时它还不拘泥于系列的原作，而是充满野心的用自己的方式来向前迈进。', '动作');
INSERT INTO `game` VALUES ('7', 'game7.jpg', '怪物猎人：世界', 'Monster Hunter:world', '99', 'CAPCOM', '2018-08-10', '《怪物猎人：世界》以叙事演出结合探索玩法，重新确立了独特的狩猎体验。兼具探索乐趣与美感的无缝地图让人津津乐道、一流的动作系统、友好的联机功能以及帅炸的钢龙和炎王龙都体现了本作诚意十足。不过有些新一代怪物的设计稍嫌中庸，后期内容还有待补充等小缺点也是无法让人完全满意。', '角色扮演');
INSERT INTO `game` VALUES ('8', 'game8.jpg', '鬼泣5', 'Devil May Cry V', '99', 'CAPCOM', '2019-03-08', '《鬼泣5》在玩法内核上依然延续了系列一直以来的设计，当初或许有观点认为它缺少变化，但现在看来，一，它做了变化；二，它没做变化的，表现得更好。当CAPCOM把这传统的ACT玩法用最新技术去呈现，玩家就会发现，硬核ACT的玩法经得起时间的考验，它在这个时代依然熠熠生辉。', '动作');
INSERT INTO `game` VALUES ('9', 'game9.jpg', '糖豆人：终极淘汰赛', 'Fall Guys: Ultimate Knockout', '80', 'Mediatonic', '2020-08-04', '在这个大型闯关综艺现场，玩家将和大批参赛者共同面对一场“欲戴皇冠必趁其乱”的冲关竞技。玩家要灵活应对野蛮生长的障碍物，挤开黏人的比赛对手，跌跌撞撞地冲锋。自踏入赛场的一刻起，就请将面子和理智丢到九霄云外，在向皇冠发起挑战的过程中，尽情享受令人捧腹的娱乐场面吧。', '休闲');
INSERT INTO `game` VALUES ('10', 'game10.jpg', '星露谷物语', 'Stardew Valley', '89', 'ConcernedApe', '2016-02-27', '游戏中玩家扮演继承了爷爷农场的“Stardew valley”主角开阔和经营整座小牧场。', '休闲');
INSERT INTO `game` VALUES ('11', 'game11.jpg', '都市：天际线', 'Cities: Skylines', '85', 'Colossal Order Ltd', '2015-03-10', '该游戏引入了全新的游戏玩法元素，让玩家切身体会到创造和维持一座真正城市的兴奋和艰辛，同时扩展了城市建设体验中的一些主题。', '休闲');
INSERT INTO `game` VALUES ('12', 'game12.jpg', '史莱姆牧场', 'Slime Rancher', '81', 'Monomi Park', '2017-08-02', '刚进入游戏就看到这么萌萌哒的史莱姆，有没有被萌翻了呢？这个游戏的世界观说的是人类在距地球一千光年以外发现了史莱姆星球，于是人类就派出我们的主角Beatrix LeBeau去史莱姆星球上探索，在圈养各种各样的史莱姆过程中，利用史莱姆拉出的粑粑，换取金钱，不断扩展牧场的势力。并且探险史莱姆星球，与具有攻击力的史莱姆搏斗。', '休闲');
INSERT INTO `game` VALUES ('13', 'game13.jpg', '植物大战僵尸', 'Plants vs. Zombies，PVZ', '87', '宝开游戏公司', '2009-05-06', '玩家通过武装多种植物切换不同的功能，快速有效地把僵尸阻挡在入侵的道路上。不同的敌人，不同的玩法构成五种不同的游戏模式，加之黑夜、浓雾以及泳池之类的障碍增加了游戏挑战性。', '休闲');
INSERT INTO `game` VALUES ('14', 'game14.jpg', 'NBA 2K21', 'NBA 2K21', '65', 'Visual Concepts', '2020-09-04', '本作的玩法、竞争性以及社区在线功能，在前作的优质基础上精益求精，作出一系列激动人心的改进，再加上更加丰富多样的游戏模式，《NBA 2K21》将带给您NBA篮球与文化世界的沉浸式体验——随心所欲。', '体育');
INSERT INTO `game` VALUES ('15', 'game15.jpg', '极限竞速：地平线 4', 'Forza Horizon 4', '85', 'Playground Games', '2021-03-10', '在世界上最盛大的汽车嘉年华上，不断变化的赛季改变着一切。单枪匹马或者与其他人组队，在一个共享开放世界中探索美丽而富有历史气息的英国。收集、改装和驾驶超过 450 辆车辆。尽情竞速、表演特技、创造和探索：选择您专属的方式来成为地平线中的超级巨星。', '竞速');
INSERT INTO `game` VALUES ('16', 'game16.jpg', '极品飞车21：热度', 'Need For Speed™:Heat', '92', 'Marcus Nilsson', '2018-10-02', '《极限竞速：地平线4》的登场依旧强势，美不胜收的大不列颠、更加丰富的车辆、四季变换的赛道，让这款竞速游戏几乎成为了无敌的存在。如果你是个执着又放荡不羁的车手，想要享受自由、奔放的驾车体验，那么拿上这份英国旅游指南，在百老汇感受蜂蜜石建筑的独特韵味，在豪斯湖的沿岸尽情驰骋吧。', '竞速');
INSERT INTO `game` VALUES ('17', 'game17.jpg', '足球经理2021', 'Football Manager 2021', '84', 'Sports Interactive', '2020-11-24', '新的内容与游戏特性升级带来了更多的游戏深度、故事性和足球世界的真实性。FM21以前所未见的方式让你开发自己的教练潜力，带领你的俱乐部走向成功。', '体育');
INSERT INTO `game` VALUES ('18', 'game18.jpg', 'NBA 2K19', 'NBA 2K19', '76', 'Visual Concepts', '2018-09-10', '从一流的画质和高度的可玩性，到突破性的游戏模式，再到令人神往的开放世界“社区”，20年来《NBA 2K》一直在不断刷新体育游戏的定义。最新力作《NBA 2K19》将继续突破极限，让玩家获得最接近真实的篮球体验、体验最纯粹的篮球文化。', '体育');
INSERT INTO `game` VALUES ('19', 'game19.jpg', '荒野大镖客：救赎2', 'Red Dead Redemption 2', '93', 'Rockstar Games', '2019-12-06', '游戏中述说亚瑟·摩根和声名狼藉的范德林德帮派的传奇故事，体验在 19 世纪的最后岁月里横跨美国的亡命之旅。除此之外，还可免费享受 Red Dead 在线模式中与众多玩家共享的逼真世界。', '冒险');
INSERT INTO `game` VALUES ('20', 'game20.jpg', '盗贼之海', 'Sea of Thieves', '81', 'Rare', '2020-06-03', '无论是航行打斗还是冒险掠夺，《盗贼之海》都能让您深刻体验海盗生涯，成为自立为王的传奇海盗。多样的角色让您可以自由探索游戏世界，并自由选择与玩家互动的方式。', '冒险');
INSERT INTO `game` VALUES ('21', 'game21.jpg', '双人成行', 'It Takes Two', '88', 'Hazelight', '2021-03-25', '游玩《双人成行》，踏上生命中最疯狂的旅程。利用好友通行证*邀请一位好友免费游玩，共同体验多种多样的乐趣，享受颠覆性的玩法挑战。', '冒险');
INSERT INTO `game` VALUES ('22', 'game22.jpg', '方舟：生存进化', 'ARK: Survival Evolved', '70', 'Studio Wildcard', '2015-06-02', '由虚幻4引擎打造的一款多人在线生存竞技网游，在一个超高自由度的开放世界里，可以体验采集、制造、打猎、收获、建造、研究以及驯服恐龙等超多自由内容，感受酷热白昼、冰冷夜晚的动态天气系统以及饥饿口渴等现实中的生存挑战，还要面对其它生存者的威胁，合作生存还是竞技厮杀，由你决定！', '冒险');
INSERT INTO `game` VALUES ('23', 'game23.jpg', '森林', 'The Forest', '83', 'Endnight Games Ltd', '2014-05-30', '《森林》是个非常具有特色的作品，它对于氛围的出色塑造让玩家在整个流程中都能感觉到紧张和压迫感，但过于复杂地下设计和吊诡的敌人AI，让你很难在这份复杂的紧张中找到游戏的乐趣。如果你热爱沙盒生存类游戏，不妨在尝试一下这款游戏，或许能够给你带来和其他同类游戏不一样的全新体验。', '冒险');
INSERT INTO `game` VALUES ('24', 'game24.jpg', '足球在线4', 'FIFA Online 4', '90', '美国艺电、EA SPEARHEAD工作室', '2020-11-22', '《FIFA Online 4》是EA经典游戏《FIFA》游戏系列的第四代网络版，该游戏系列拥有FIFA国际足联组织的官方授权，游戏覆盖了全球37个主要联赛，47支国家队，以及1.5万名以上的在册职业球员。与此同时，FIFA Online 4还取得了中国足球超级联赛授权，将植入包含中超球员头部建模以及球场建模等在内的内容。', '体育');
INSERT INTO `game` VALUES ('28', 'game28.jpg', '飙酷车神2', 'The Crew2', '75', '象牙塔工作室，UbisoftReflections', '2018-06-29', '《飙酷车神（The Crew 2）》是由育碧发行的一款赛车竞速游戏，是《飙酷车神》的最新续作。整个游戏都由无缝连接的地图和实时在线网络连接而整合为一体，玩家可以在单人和多人模式之间进行切换。玩家不仅可以与好友一起进行合作竞速挑战，而且还能与其他玩家进行竞技，在开放的游戏世界中，全美国地图任君驰骋。', '竞速');
INSERT INTO `game` VALUES ('29', 'game29.jpg', '上古卷轴5：天际', 'The Elder Scrolls V: Skyrim', '90', 'Bethesda Game Studios', '2011-11-11', '游戏的背景时间设定在《上古卷轴4：湮没》的200年之后，地点为人类帝国的天际省。玩家将扮演传说中的龙裔，踏上对抗世界吞噬者巨龙奥杜因的征途。另外，还有天际内战、魔神器、地下遗迹、组织势力等各类支线和隐藏任务，具有庞大的世界观和高自由度。', '角色扮演');
INSERT INTO `game` VALUES ('30', 'game27.jpg', '龙腾世纪3：审判', 'Dragon Age 3：Inquisition', '88', 'BioWare', '2014-11-18', '游戏的故事始于大灾变事件，Thedas大陆陷入混乱的时期，巨龙笼罩世界，以往的平和国度化为战争之地，魔法师将与圣殿骑士全面对抗，玩家将操控一支新的种族来重新定义秩序，打破混乱——玩家的作为将会永远改变《龙腾世纪》的世界。', '角色扮演');
INSERT INTO `game` VALUES ('32', 'game32.jpg', '命令与征服：红色警戒3', 'Command & Conquer: Red Alert 3', '89', 'Command & Conquer: Red Alert 3', '2008-11-03', '过场的产品价值给人留下深刻的印象，演员表演出色，充满了乐趣，并很好的定义了游戏的风格。明亮且饱和，《红色警戒3》像一本活灵活现的漫画书，但遗憾的是难以解释为什么镜头不能拉伸太多。即兴重复的音乐特性，《地狱进行曲3》的新版本，其它音乐表现得也很出色。游戏性在本质上没有什么进化，当然它是有趣的，但是对这一游戏类型没有做出新的启示或者重新定义。游戏的单人战役和电影将花上玩家不少的时间，但在这之后如果玩家想继续完这部游戏，还要依赖于联机部分。', '策略');
INSERT INTO `game` VALUES ('34', 'game34.jpg', '星际争霸Ⅱ', 'StarCraftⅡ', '88', 'Blizzard Entertainment', '2009-07-01', '《星际争霸2》的画面效果、生效、上手体验以及耐玩性都获得了很高的评价，但是在主线剧情上，暴雪将《星际争霸2》的故事分成了一个三部曲，这一做法有利有弊，从《虫群之心》的正式发售开始，证实了大型资料片比起小型DLC更容易获得玩家的认可；而《虚空之遗》的泛用性评价更高，人能够同时被休闲玩家和核心对战玩家接受，被评为最好玩的一个版本，其执政官模式和任务合作模式兼顾了两类玩家的需求。它是一个电子竞技项目，但它也是一款游戏。', '策略');
INSERT INTO `game` VALUES ('35', 'game35.jpg', '最高指挥官2', 'Supreme Commander 2', '81', 'Gas Powered Games', '2010-03-02', '最高指挥官（Supreme Commander,SC）碍于《横扫千军》游戏版权及名称使用权皆不属于克里斯·泰勒自家的 Gas Powered Games游戏公司所拥有，因此这款游戏将会被取名为《最高指挥官》；而《最高指挥官》虽然不是《横扫千军》的官方正统续作（因为先前曾经有韩国Phantagram 表示取得《横扫千军2》开发权），不过基本上 TA 迷们 \"理论上\" 还是会宁可追随 TA 原游戏制作人克里斯·泰勒的脚步来尝试这款《最高指挥官》，总比近来无消无息的《横扫千军2》还来得让玩家有希望。', '策略');
INSERT INTO `game` VALUES ('36', 'game36.jpg', '文明VI', 'Sid Meier\'s Civilization VI', '86', 'Firaxis Games', '2016-10-21', '游戏中玩家建立起一个帝国，并接受时间的考验。玩家将创建及带领自己的文明从石器时代迈向信息时代，并成为世界的领导者。在尝试建立起世界上赫赫有名的伟大文明的过程中，玩家将启动战争、实行外交、促进文化，同时正面对抗历史上的众多领袖。', '策略');

-- ----------------------------
-- Table structure for hotgame
-- ----------------------------
DROP TABLE IF EXISTS `hotgame`;
CREATE TABLE `hotgame` (
  `hotGameID` int NOT NULL,
  PRIMARY KEY (`hotGameID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of hotgame
-- ----------------------------
INSERT INTO `hotgame` VALUES ('1');
INSERT INTO `hotgame` VALUES ('4');
INSERT INTO `hotgame` VALUES ('5');
INSERT INTO `hotgame` VALUES ('6');
INSERT INTO `hotgame` VALUES ('7');
INSERT INTO `hotgame` VALUES ('8');
INSERT INTO `hotgame` VALUES ('10');
INSERT INTO `hotgame` VALUES ('11');

-- ----------------------------
-- Table structure for topline
-- ----------------------------
DROP TABLE IF EXISTS `topline`;
CREATE TABLE `topline` (
  `newsImage` varchar(100) NOT NULL,
  `newsText` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`newsImage`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of topline
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userID` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `nickname` varchar(20) DEFAULT NULL,
  `head` varchar(100) DEFAULT NULL,
  `gender` varchar(5) DEFAULT NULL,
  `profile` varchar(100) DEFAULT NULL,
  `loved` varchar(100) DEFAULT NULL,
  `birthday` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=100033 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('100001', 'azirkxs', '123456', 'azirkxs123', 'head0.jpg', '男', '我一个人干活，这对大家都好', '0;4;7', '2001-09-06');
INSERT INTO `user` VALUES ('100002', 'lijianguang', '123456', '李建光', 'head1.jpg', '男', '这个人很懒', '1', '');
INSERT INTO `user` VALUES ('100003', 'zhangjinglong', '123456', '张景隆', 'head1.jpg', '男', '这个人很懒', '1', '');
INSERT INTO `user` VALUES ('100025', '995586226', '123456', '不愿意透露姓名', 'head0.jpg', '男', '我一个人干活，这对大家都好', '0;1;2;3;4;5;6;7', '2001-09-06');
INSERT INTO `user` VALUES ('100027', '123456', '123456', '测试用户', 'head1.jpg', '男', '我是一个无情的测试机器人！！！', '0;1;4', '2001-09-06');
INSERT INTO `user` VALUES ('100030', '9955862262', '123456', null, null, null, null, null, null);
