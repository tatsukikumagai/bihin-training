# 社内備品予約システム API（研修用）

社内の備品（ノートPC・デスクなど）の情報と、その予約を管理するAPIです。開発基礎（DV-101〜107）で作った `item-reservation-api` をもとにしています。AI駆動開発基礎（AD-020〜）の演習で使います。

## 使用技術

- Java 25
- Spring Boot 4.1.1（Spring Web・Spring Data JPA・Lombok）
- MySQL（データベース `reservation_db`）
- JUnit・Mockito（テスト）

## 起動方法

1. MySQLに `reservation_db` があることを確かめる。DV-080で作っていない場合は、DBeaverで `db/setup.sql` を実行する
2. プロジェクトのフォルダ直下に `application-local.properties` を作り、次の1行を書く（このファイルはコミットされない）

   ```properties
   spring.datasource.password=（EN-004で設定した研修共通のパスワード）
   ```

3. VS Codeで `ItemReservationApiApplication.java` を開いて実行する。またはターミナルで次を実行する

   ```bash
   ./mvnw spring-boot:run
   ```

4. ブラウザで `http://localhost:8080/items` を開き、備品の一覧が表示されることを確かめる

## API

|メソッド|URL|内容|
|---|---|---|
|GET|`/items`|備品の一覧を取得する|
|GET|`/items/{id}`|備品を1件取得する|
|POST|`/items`|備品を登録する|
|PUT|`/items/{id}`|備品を更新する|
|DELETE|`/items/{id}`|備品を削除する|
|GET|`/reservations`|予約の一覧を取得する|
|GET|`/reservations/{id}`|予約を1件取得する|
|POST|`/reservations`|予約を登録する|
|PUT|`/reservations/{id}`|予約を更新する|
|DELETE|`/reservations/{id}`|予約を削除する|

## テストの実行

```bash
./mvnw test
```

`ItemServiceTest` は、データベースに接続せずに実行できます（`ItemRepository` をモックにしているため）。

## フォルダ構成

|フォルダ・ファイル|中身|
|---|---|
|`src/main/java/com/example/item_reservation_api/`|Controller・Service・Repository・Entity|
|`src/main/resources/application.properties`|アプリケーションの設定（データベースの接続先など）|
|`src/test/java/com/example/item_reservation_api/`|テスト|
|`db/setup.sql`|データベースを作るSQL（DV-080と同じ内容）|
|`docs/`|要件定義メモ・設計メモの置き場所|
|`.github/`|Issue・Pull Requestのテンプレート|
