# NlabQuest  
RPGの戦闘ゲーム.  
オブジェクト指向的に書く練習.  


# 備考  
eclipse で作ったので、 pull したら使えるはず.  

文字コード : UTF-8  
改行コード : CR+LF(Windows)  

# クラス図(大雑把)  
## 基底オブジェクト  
ステータスなどを保持しているクラス関連.  
BaseXxx にデータを保持.  
Builder をコンストラクタで組み立てる形.
派生クラスを Abstract にしておくことで、 Factory クラスで使いやすくする.

BaseAction ─ Action - AbstractXxxxAction ─ DefaultXxx  
│  
Builder  

BaseUnit ─ Unit  
│  
Builder  

Unit  
├ Action  
└ Command  

## その他クラス  
各オブジェクト群は、 factory クラスを使って生成する.  
UnitManager  

ActionFactory  
UnitFactory  
