# lab 8

    本节目标：
    1. 掌握面向对象继承，能够使用面向对象方法设计魔塔对象
    2. 理解多态性
    3. 以上


## 使用面向对象方法设计魔塔对象

PJ 1 已经结束了。根据大家的完成情况，助教们发现了几个问题：

1. 命名不规范，变量名没有语义，理解困难
2. 单个方法超过 50 行
3. 存在冗余、重复的代码
4. 使用超长的 `if-else if` 或者 `switch-case`，导致代码好像面条，可读性很差

第 1, 2, 3 个问题基本归因于 Coder 的基本功不够扎实，大家多敲多看代码就能解决，至于第 4 个问题好像无解，但是其实我们可以尝试利用面向对象编程来规避。

接下来，助教将会展示如何用面向对象方法分析与设计魔塔对象，其中包括了继承的知识点，请认真阅读，然后尝试用代码再次实现魔塔的部分功能。

既然我们使用面向对象，我们就应该知道魔塔游戏中哪些部分可以看作对象。 **对象应该有自身的属性，且这些属性不应该允许其他对象直接更改；对象应该有自身的方法，对象可以通过调用自身的方法影响自己与外界对象。** 考虑到这些，我们可以认定：

- 魔塔中的每一个格子可以作为一个对象。因为：
    1. 每一个格子都有自己的方法，比如告诉外界自己应该在命令行中显示的字符
- 魔塔应该有一个玩家对象。因为：
    1. 玩家对象有自己的属性：如血量，攻击力，防御力等
    2. 玩家对象应该有移动方法，用来控制自身的移动；应该有告诉外界自己应该在命令行中显示的字符的方法；应该有告诉外界自己是否在某个位置的方法等
- 魔塔应该有一个地图对象。因为：
    1. 地图对象可以将储存格子对象的二维数组作为自己的属性，将玩家对象作为自己的属性
    2. 地图对象需要有一个 `print` 方法，向命令行打印每个格子对象表示的字符

于是我们有了三个类——格子类、玩家类与地图类——用来创建格子对象、玩家对象和地图对象，代码如下：
- Lattice.java
    ```java
    public class Lattice {
        public Lattice() {
        }

        public String getAppearance() {
            return "空";
        }
    }
    ```

- Player.java
    ```java
    public class Player {
        private int[] position;
        private int[] nextPosition;

        public Player(int[] position) {
            this.position = position;
        }

        public boolean move(/* add some parameters */) {
            // do something
            return false;
        }

        public boolean isOnThePosition(int positionX, int positionY) {
            return position[0] == positionX && position[1] == positionY;
        }

        public String getAppearance() {
            return "勇";
        }
    }
    ```

- MotaMap.java
    ```java
    public class MotaMap {
        private Lattice[][] lattices;
        private Player player;

        public MotaMap(Lattice[][] lattices, Player player) {
            this.lattices = lattices;
            this.player = player;
        }

        public void print() {
            int row = lattices.length;
            int column = lattices[0].length;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    if (player.isOnThePosition(i, j)) {
                        System.out.print(player.getAppearance());
                    } else {
                        System.out.print(lattices[i][j].getAppearance());
                    }
                }
                // 换行
                System.out.println();
            }
        }
    }
    ```

接下来我们需要具体考虑各种格子的特性了
- 将史莱姆、骷髅、魔王等怪物归纳为怪物类，继承格子类，怪物类相对于格子类需要有血量，攻击力，防御力等属性，需要有战斗方法，死亡方法等方法
- 将宝石、血瓶、钥匙、最终宝物等物品归纳为物品类，继承格子类，物品类相对于格子类需要有增幅属性和被使用方法
- 将各种门视作门类，继承格子类，门类相对于格子类需要有类型属性（用于判断对应钥匙）和开门方法
- 将上下楼视作楼梯类，继承格子类，楼梯类相对于格子类需要有传送到楼层，位置等属性，需要有传送方法
- 将商人视作商人类，继承格子类，商人类相对于格子类需要有增幅属性和消耗金钱等属性，需要有卖出方法
- 将墙视作墙壁类，继承格子类，玩家无法移动进墙壁里

然后我们会发现，对于目前划分的类，可能还不够细致，需要继续划分，比如物品类需要继续细分为宝石类、血瓶类、钥匙类和最终宝物类

具体代码实现这里不再细说

    这次 lab 已经给出一个魔塔项目，可以打印地图，移动勇者，且实现了勇者不能进入墙壁的功能。请大家阅读代码，理解面向对象是如何规避使用 switch-case 的，并参照 Wall 类，重写 Monster, Material, Door, Stairs, Merchant 类的 affectWith 方法，实现以下功能：
    1. 使 Monster 对象能和玩家战斗（前提是需要增加血量，攻击力，防御力属性）
    2. 使玩家能从 Material 对象处拿到钥匙打开 Door 对象（前提是需要增加钥匙属性）
    3. 使玩家能从商人处用 20 金买到 3 点攻击力（前提是需要增加金钱属性）
    4. 当玩家走上楼梯，在命令行打印："二楼正在整修，敬请期待"

> 如果有必要，允许大家在任何位置插入任何代码
>
> 请尽量使用私有属性，通过 getter, setter 方法获取修改私有属性

## 多态性

大家一定已经发现 `Lattice` 类的 `affectWith`, `getAppearance` 方法就展现了多态性：同样的类的对象调用同样的方法却有不同的反应。这是类的多态性。除此之外，多态性还有另外一种表现，那是什么？是如何表现的？请举例说明，将答案写在 Word 文档中，与代码一起打包提交。


## 提交
DDL: 2019 年 11 月 24 日 23:59

以 `学号_姓名.文件` 类型的格式命名，如 `16302010027_毛浩楠.zip` 。上传至FTP

    ftp://10.132.141.33/classes/19/191 程序设计A （陈荣华）/WORK_UPLOAD/lab8