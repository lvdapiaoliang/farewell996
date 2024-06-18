DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp`  (
                        `EMPNO` int NOT NULL COMMENT '员工号',
                        `ENAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '员工姓名',
                        `JOB` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '职位',
                        `MGR` int NULL DEFAULT NULL,
                        `HIREDATE` date NULL DEFAULT NULL COMMENT '入职日期',
                        `SAL` int NULL DEFAULT NULL COMMENT '薪资',
                        `COMM` int NULL DEFAULT NULL COMMENT '奖金',
                        `DEPTNO` int NULL DEFAULT NULL COMMENT '部门编号',
                        PRIMARY KEY (`EMPNO`) USING BTREE,
                        INDEX `empno_index`(`EMPNO` ASC) USING BTREE COMMENT '员工号索引',
                        INDEX `ename_index`(`ENAME` ASC) USING BTREE COMMENT '员工姓名索引',
                        INDEX `eeptno_index`(`DEPTNO` ASC) USING BTREE COMMENT '部门编号索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

INSERT INTO `emp` VALUES (7369, 'SMITH', 'CLERK', 7902, '2005-12-17', 800, NULL, 20);
INSERT INTO `emp` VALUES (7499, 'ALLEN', 'SALESMAN', 7698, '2006-02-20', 1600, 300, 30);
INSERT INTO `emp` VALUES (7521, 'WARD', 'SALESMAN', 7698, '2006-02-22', 1250, 500, 30);
INSERT INTO `emp` VALUES (7566, 'JONES', 'MANAGER', 7839, '2006-04-02', 2975, NULL, 20);
INSERT INTO `emp` VALUES (7654, 'MARTIN', 'SALESMAN', 7698, '2006-09-28', 1250, 1400, 30);
INSERT INTO `emp` VALUES (7698, 'BLAKE', 'MANAGER', 7839, '2006-05-01', 2850, NULL, 30);
INSERT INTO `emp` VALUES (7782, 'CLARK', 'MANAGER', 7839, '2006-06-09', 2450, NULL, 10);
INSERT INTO `emp` VALUES (7788, 'SCOTT', 'ANALYST', 7566, '2006-12-09', 3000, NULL, 20);
INSERT INTO `emp` VALUES (7839, 'KING', 'PRESIDENT', NULL, '2006-11-17', 5000, NULL, 10);
INSERT INTO `emp` VALUES (7844, 'TURNER', 'SALESMAN', 7698, '2006-09-08', 1500, 0, 30);
INSERT INTO `emp` VALUES (7876, 'ADAMS', 'CLERK', 7788, '2008-01-12', 1100, NULL, 20);
INSERT INTO `emp` VALUES (7900, 'JAMES', 'CLERK', 7698, '2006-12-03', 950, NULL, 30);
INSERT INTO `emp` VALUES (7902, 'FORD', 'ANALYST', 7566, '2006-12-03', 3000, NULL, 20);
INSERT INTO `emp` VALUES (7934, 'MILLER', 'CLERK', 7782, '2007-01-23', 1300, NULL, 10);

DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
                         `DEPTNO` int NOT NULL COMMENT '部门编号',
                         `DNAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '部门名称',
                         `LOC` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '位置',
                         PRIMARY KEY (`DEPTNO`) USING BTREE,
                         INDEX `deptno_index`(`DEPTNO` ASC) USING BTREE COMMENT '部门编号索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

INSERT INTO `dept` VALUES (10, 'ACCOUNTING', 'NEW YORK');
INSERT INTO `dept` VALUES (20, 'RESEARCH', 'DALLAS');
INSERT INTO `dept` VALUES (30, 'SALES', 'CHICAGO');
INSERT INTO `dept` VALUES (40, 'OPERATIONS', 'BOSTON');

DROP TABLE IF EXISTS `t1`;
CREATE TABLE `t1`  (
                       `ID` int NOT NULL COMMENT 'id',
                       PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

INSERT INTO `t1` VALUES (1);

DROP TABLE IF EXISTS `t10`;
CREATE TABLE `t10`  (
                        `ID` int NOT NULL COMMENT 'id',
                        PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

INSERT INTO `t10` VALUES (1);
INSERT INTO `t10` VALUES (2);
INSERT INTO `t10` VALUES (3);
INSERT INTO `t10` VALUES (4);
INSERT INTO `t10` VALUES (5);
INSERT INTO `t10` VALUES (6);
INSERT INTO `t10` VALUES (7);
INSERT INTO `t10` VALUES (8);
INSERT INTO `t10` VALUES (9);
INSERT INTO `t10` VALUES (10);