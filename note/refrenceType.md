#引用类型 refrence type

引用类型的值，是引用类型的一个实例，在ecmascript中，引用类型是一种用于建个数据和功能组合在一起的数据结构。引用类型也可以被称为类，但是在ecamaScript
中，并没有传统的面向对象的类和接口的基本结构，所以并不是我们传统意义上的类（但是在ecma6中，已经有了class和接口语法）引用类型有时候也被称为对象定义，因为
他们描述的是一类对象所具有的属性和方法


- 对象：对象是某个特定引用类型的实例，新对象是使用 new+构造函数来创建的，构造函数的本身也是函数，不过他是以创建新对象为目的来定义的。
```
var person = new Object;
```
ecmaScript给我们定义了许多原生引用类型，object就是其中一种。

- object类型：创建object类型有两种方式：第一种是new操作符后跟object构造函数
```·
let person = new Object()
```
另外一种是对象字面量法
```
let person = {}
```
我们平时在开发中经常用到的是第二种方法，因为这样看起来有一点数据被封装的感觉，访问对象中的属性有两种方法，一种是点表示法，一种是中括号表示法。
```
let person = {
    name : "frank"
}
alert(person.name);
alert(person[name]);
```
我们一般都会使用点表示法，使用中括号表示法的情况一般在要用变量作为属性名的时候
```
let property = "age";
let person = {};
person[property] = 24;
```

- array类型：





