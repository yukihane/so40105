# これは何？

[java - 複数のwarファイル間でクラスを共有したい - スタック・オーバーフロー](https://ja.stackoverflow.com/questions/40105/)
に対するサンプル実装コード。

# 付与したタグの説明

|タグ名|説明|
|---|---|
|`tag/fat-war`|依存`JAR`を`WAR`の中に含めている状態。(比較用。質問文中にある現状態。)|
|`tag/global-module`|グローバルモジュールとしてロードする場合。|
|`tag/jboss-deployment-structure`|`WAR`の中の`jboss-deployment-structure.xml`ファイルでロードするモジュールを指定する場合。(`tag/global-module`から見た差異は、当ファイルが含まれるか否かのみ。)|
|`tag/manifest.mf`|`WAR`の中の`MANIFEST.MF`ファイルでロードするモジュールを指定する場合。(`tag/global-module`から見た差異は、`MANIFEST.MF`ファイルに`Dependencies:`セクションを追記するか否かのみ。)|

# ビルド方法

Mavenを導入した上で

    mvn clean package

# デプロイ

`hello-api/target/hello-api-0.0.1.jar`, `hello-api-impl/target/hello-api-impl-0.0.1.jar`, `res/modules/system/layers/base/com/github/yukihane/wildfly-sharing-jar/main/module.xml`
の3ファイルは
`$JBOSS_HOME/modules/system/layers/base/com/github/yukihane/wildfly-sharing-jar/main/`
にコピーする。

`hoge-war/target/hoge.war`, `fuga-war/target/fuga.war` の2ファイルは
`$JBOSS_HOME/standalone/deployments` にコピーする。

加えて、global moduleとして本モジュールを登録する場合は
`$JBOSS_HOME/standalone/configuration/standalone.xml` に
`res/standalone.xml.diff` の差分を適用する。

# 実行

    $JBOSS_HOME/bin/standalone.sh

- http://localhost:8080/hoge/hoge
- http://localhost:8080/fuga/fuga

でそれぞれの`WAR`で実装されたサーブレットにアクセスできる。
