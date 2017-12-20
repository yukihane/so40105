# これは何？

[java - 複数のwarファイル間でクラスを共有したい - スタック・オーバーフロー](https://ja.stackoverflow.com/questions/40105/)
に対するサンプル実装コード。

# ビルド方法

global module方式を試したいならタグ `tag/global-module`, `jboss-deployment-structure.xml`で制御するなら `tag/jboss-deployment-structure`を用いる。
なお違いは `jboss-deployment-structure.xml`が含まれるか否かのみ。

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

http://localhost:8080/hoge/hoge
http://localhost:8080/fuga/fuga

でそれぞれの`WAR`で実装されたサーブレットにアクセスできる。
