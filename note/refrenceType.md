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

- array类型：js中的数组，跟java等语言中的数组相比，十分的简便，第一他无需指定需要存入的数据类型，第二他无需指定需要创建数组的大小。js中的数
组数组有几种声明方法：
````
let array = new Array(200)  //创建一个长度为200的数组，也可以不指定长度

let array = []

let array = Array()
````
还有一个需要注意的问题，array中的length属性是可以写的，比如：
```
let array = [1,2,3];
console.log(array.length)    //3
array.length = 2
console.log(array)  //[1,2]
```
整体的效果就相当于将最后一位删除了，当然如果我们增加的话，余下的都会获得undefined值

- 检测数组：instanceOf来检测数组不太好，所以es5新增了  Arrary.isAaary方法来判断是否为数组，其实我们还有一个方法来判断 Object.prototype.toString。
 如果是数组的话，会返回`[object Array]`，同理此方法还能判断正则、undefined、null
 
 -转换方法：所有对象都具有 toString、valueOf、toLocalString方法，而在数组中，`valueof`返回的还是这个数组，`tostring`则让数组中每一项调
 用他们自身的`toString`方法。同理tolocalString 就是每一项都调用他们的toLocalString方法。当然，这些方法都是能够在对象中被重写的。重写之后
 就会调用重写之后的方法，注意，如果数组中的某一项是null或者undefined，那调用他们的join或者tostring方法，那一项就会是空字符串
 ```
 let array = [1,null,2]
 console.log(array.toString())  //"1","","2"
 ```
- 栈：首先栈是一种LIFO（后进先出）的数据结构，而js中的数组可以看做是类似的结构，这里我们需要讲到两种方法`push`，这个方法在数组的最末端插入
一项，并且返回数组的长度`pop`：该方法删除数组最后一项，并且返回该项的值

- 队列：相对于LIFO结构的栈而言，队列是一种FIFO（先进先出）的数据结构，我们的数组也能实现类似队列的功能，`shift`方法可以移除数组中的第一项，
并返回该项，那么我们如何在数组的最最前端插入数据呢？`unshift`,它的效果跟push相同，只是方向相反。

- revert方法：数组中，revert方法就是将数组反向排列；

- sort方法：数组中的sort方法，默认是将数组由小到大排列，该方法调用数组中每一项的toString方法，即使是数值，它还是比较字符串。但是sort方法
可以接受一个比较函数作为参数，所以我们在一般的使用中，都会在sort方法中传入一个方法，让它能够正确比较
```
let array = [1,3234,23,5335,346,363,32,23,23,23];
array.sort((a,b)=>a>=b?1:-1);       //理解为两项相减，前面项大于等于则返回正数，小于则返回负数
console.log(array);
```

- concat:它可以拼接数组或对数组进行深拷贝，它会先创建这个数组的一个副本，然后将接收到的参数添加到数组的末尾。

- slice:该方法接收两个参数，一个是起始位置，一个结束位置，它将返回起始位置和结束位置之间的数组，当它只有一个参数的时候，就返回起始位置到数组
结束位置的数组，当值为负数的时候，就把这个值加上数组长度，异常情况它将返回空数组，注意！它返回的值包含起始位置不包含结束位置,并且它依然是从
零开始。
```
let array = [1,2,3,4]
array.slice(1,2)    //[2]
```
- splice:它是一个万金油方法

**删除**，传入两个参数，第一个参数是起始位置，第二个参数表示删除数量，这里删除的包括起始位置项。

**插入**，传入多个参数，第一参数是起始位置，第二个参数为0，表示不删除，接下来的若干个参数都是插入的项目，注意其实位置也会被后移，举个栗子
```
let array = [1,2,3,4]
array.splice(2,0,8,8,8)
console.log(array)  //[1, 2, 8, 8, 8, 3, 4]
```
从上述代码可以看出，它在起始位置之前添加

**替换**，与上面方法相同，第一项是起始位置，第二项是替换个数，从第三项开始是替换的项目，如果替换的项目不够，那多余的就会被删除，如果多了，就
会添加

- indexOf和lastIndexOf：这两个方法都是查询传入值在数组中的位置，只是一个是从前向后，一个是从后向前。它还能接收第二个参数，从第几项开始查找，
注意这个方法的查找是使用的===全等来进行查找，也就意味着1和"1"不是一个东西。

- 迭代方法：ecmaScript定义了五个迭代方法，他们都接收两个参数——要在没一项上运行的函数和运行该函数的作用域对象（this），其中第二个参数是可
选的。函数又能接收三个参数，第一个是当前项，第二个是当前项的index，第三个是数组本身;

`every`：对数组中每一项运行函数，如果函数对每一项都返回true，则返回true

`filter`：对数组中每一项运行该函数，返回该函数返回true项的数组
```
let array = [1,2,3,4]
let array2 = array.filter(number=>number>2)
console.log(array2) //[3,4]
```
`forEach`：对数组中每一项运行该函数，该函数没有返回

`map`:对数组中每一项运行该函数，返回每一次函数运行后结果的数组

```
let array = [1,2,3,4]
let array2 = array.map(number=>number+1)
console.log(array2) //[2,3,4,5]
```

`some`：对数组中每一项运行该函数，如果函数的任意一项返回true，则返回true

总结一下，这几个函数，every和some作用相同，只是every是与关系而some是或关系，forEach用于没有返回但是每项都需要操作的情况，filter适合需要
通过某些条件来返回新数组的情况，map适合需要对每一项进行操作并返回新数组的情况

- 缩小方法，跟迭代方法相同，我们数组也有缩小方法，这两个方法都会迭代数组中的每一项，然后产生一个返回值这两个方法分别是 reduce、reduceRight。
从他们的名字我们就能够看到他们的区别，reduce从左到右，reduceRight从右到左，类似的，他们也接收两个参数，第一个参数是应用于每一项的函数，第二
个是函数运行的作用域对象（this），函数接收四个参数，第一个参数为上一个值，第二个参数为现在的值，三个参数为当前的index，第四个参数为数组本身，
当然，缩小方法也不会影响到数组本身，只是单纯的返回值。
```
 'use strict';
let array = [1,2,3,4]
let array2 = array.reduce((pre,cur,index,arr)=>pre+cur);    //求和运算
console.log(array2)     //10
```
这里注意，它总是从数组的第二项开始运行方法，因为第一项会没有pre

- Date类型：它是基于java.util.Date来创建的，创建日期对象跟普通对象的创建方法相同， new Date就行了，而且date都会根据本地时区来创建

`Date.UTC()`：参数：基于0的年份（比如一月就需要传入0），月中的那一天（1-31）小时数（0-23），分、秒、毫秒，这几个参数，只有年、月
是必须的，其他都是非必须

日期还为我们提供了一个很方便的方法来获取当前的毫秒数，这个可以用来检测执行的时间，Date.now；当然检测时间我们还能用console中的time方法，
这个方法的用法：
```
console.time("array2")
    let array = [1,2,3,4]
    let array2 = array.reduce((pre,cur,index,arr)=>{
        console.log(pre, cur, index)
        return pre + cur
    });    //求和运算
    //console.log(array2)     //10
    console.timeEnd("array2")   //array2: 3.60595703125ms
```
time表示启动计时器，timeEnd表示停止计时器，中间传入的字符串代表的对应timer；

-日期的toString、toLocalString、valueOf方法：toString 方法直接返回英文对应的当前时间，而toLocalString可以返回中文的时间，带有上午
下午标识，valueOf则返回日期的毫秒数，跟调用getTime()方法的效果是一样的

- 日期的格式化：Date类型还有专门格式化日期的方法
`toDateString` :显示星期、月、日、年，它有一个根据本地来显示的方法`toLocaleDateString`

`toTimeString`：显示时、分、秒，它有一个根据本地来显示的方法`toLocaleTimeString`

`toUTCString`：显示完成的日期，它没有toLocale的方法

当然还有许多日期时间组件的方法，详见高程121页，可以尝试一下写一个日期组件哟；

- 正则（RegExp）

