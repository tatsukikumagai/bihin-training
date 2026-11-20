-- 社内備品予約システムのデータベース（DV-080のハンズオンと同じ内容）
-- DV-080でreservation_dbを作成済みの場合は、実行しなくてよい。
-- 作り直すときは、DBeaverで次のSQLを上から順に実行する（既存のデータは消える）。

CREATE DATABASE IF NOT EXISTS reservation_db;
USE reservation_db;

DROP TABLE IF EXISTS 予約;
DROP TABLE IF EXISTS 備品;
DROP TABLE IF EXISTS 備品カテゴリ;

CREATE TABLE 備品カテゴリ (
    カテゴリID INT AUTO_INCREMENT PRIMARY KEY,
    カテゴリ名 VARCHAR(20) NOT NULL
);

CREATE TABLE 備品 (
    備品ID     INT AUTO_INCREMENT PRIMARY KEY,
    備品名     VARCHAR(20) NOT NULL,
    在庫数     INT NOT NULL,
    カテゴリID INT NOT NULL,
    FOREIGN KEY (カテゴリID) REFERENCES 備品カテゴリ(カテゴリID)
);

CREATE TABLE 予約 (
    予約ID   INT AUTO_INCREMENT PRIMARY KEY,
    備品ID   INT NOT NULL,
    予約日   DATE NOT NULL,
    予約者名 VARCHAR(20) NOT NULL,
    予約個数 INT NOT NULL,
    FOREIGN KEY (備品ID) REFERENCES 備品(備品ID)
);

INSERT INTO 備品カテゴリ (カテゴリ名) VALUES
('PC機器'),
('什器'),
('文具');

INSERT INTO 備品 (備品名, 在庫数, カテゴリID) VALUES
('ノートPC', 5, 1),
('モニター', 0, 1),
('デスク', 3, 2),
('椅子', 4, 2),
('本棚', 2, 2),
('ボールペン', 20, 3);

INSERT INTO 予約 (予約ID, 備品ID, 予約日, 予約者名, 予約個数) VALUES
(101, 1, '2026-08-01', '田中太郎', 1),
(102, 2, '2026-08-02', '鈴木花子', 1),
(103, 3, '2026-08-03', '佐藤太郎', 2),
(104, 1, '2026-08-05', '田中太郎', 1),
(105, 4, '2026-08-06', '鈴木花子', 3);
