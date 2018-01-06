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

- 正则（RegExp）:正则的一般写法是
```
let expression = /pattern/flags
``` 
其中的pattern部分是正则表达式，每个正则表示可以有一个或多个flags，flag可以为

`g`：表示全局（global）模式，它表示规则将被用来匹配所有字符串，而不是发现第一个匹配项就立即停止

`i`：表示不区分大小写模式（case-insensitive），它表示在匹配时忽略字符串的大小写

`m`：表示多行匹配（multiline），它表示搜索到一行末尾时，还会搜索下一行有没有匹配项

转译：模式中使用过的所有元字符都需要进行转译，这些字符有：
```
{ } ( ) [ ] \ ^ $ | ? * + .
```
转译使用\来进行转译，举个栗子
```
//匹配第一个bat或者cat，不区分大小写
let rexp = /[bc]at/i;
//匹配第一个[bc]at，不区分大小写
let rexp2 = /\[bc\]at/i 
```
前面我们都用的对象字面量来创建的正则，当然我们也可以使用构造函数的方式来创建正则,它接收两个参数，第一个参数是pattern，第二个参数是flag;
```
let rexp = new RegExp(pattern,flag)
//举个栗子,下面两个正则是完全相同的
let rexp1 = /[bc]at/i;
let rexp2 = new RegExp("[bc]at","i")
```
但是我们要注意的是，构造函数的两个参数都是字符串，所以其中的那些元字符就需要双重转译，比如
```
/\[bc\]at === "\\[bc\\]at"
```
- RegExp的实例属性：

`global`:布尔值，表示是否设置了g标志；

`ignoreCase`：布尔值，表示是否设置了i标志；

`lastIndex`：int，表示开始搜索下一个匹配项的字符位置，从0开始；

`multiline`：布尔值，表示是否设置了m标志；

`source`：返回正则表达式的字符串表示，当为字面量创建正则时返回；

- RegExp的实例方法

`exec`：该方法接受一个参数，即需要匹配的项，它返回一个数组，数组中有两个属性，input和index，input是传入的匹配项，index是匹配到第一项的位置，
需要特别注意的是，就算设置了`g`标志，它每次也只会返回一个匹配项。但是多次调用后它会从上次匹配到的项开始向后匹配。

`test`：该方法接收一个字符串参数，这个属性根据是否匹配到返回true和false，经常用于if判断中

`toString tolocaleString`：这两个方法都会返回正则表达式的字面量，跟创建正则的方法无关

- function类型：function是js中最优意思的一个东西，它实际上也是一个对象，并且它有以下几种创建方法：
```
//函数声明
funtion test(arg1){
    alert(arg1)
}
//表达式
var test = function(arg1){
    alert(arg1)
};
//构造函数（不推荐）
var teest = new Fction("arg1","alert(arg1)")
```
但是我们并不推荐使用构造函数的方式来创建方法，因为这样会让导致代码两次解析，第一次是解析常规ecma代码，第二次是解析传入的字符串。而函数声明和
函数表达式两种声明函数的方法，也有一些区别，举个栗子
```
//这段代码不会报错
console.log(sum(1,2))
function sum(num1, num2) {
    return num1 +num2
}

//这段代码会报错
console.log(sum(1,2))
let sum = function (num1, num2) {
    return num1 +num2
}
```
为什么两种差不多的方式，会有这种区别呢，那是因为js中有着函数声明提升的机制，在代码开始执行之前，第一个方法实际上已经在内存中了，所以可以直接
提取出来使用个，而使用表达式的时候，sum中最开始被读取的时候，里面存的是undefined，当执行了真正的赋值操作后，它才会存有指向函数的指针，当然
这两种方式，除了这个区别外，并没有其他区别。

- 函数是**对象**，函数名只是指向这个对象的指针，举个栗子：
```
 let sum = function (arg1, arg2) {
     return arg1+arg2
 };
 let anOtherSum = sum;
 console.log(sum(1,2));  //3
 console.log(anOtherSum(1,2));   //3
```

- 没有重载，在java等语言中，当你传入不同数量的变量时，就可以对应不同的方法，但是我们的js并不能做到，从前面的例子中我们能够知道，函数只是一
个特殊的对象，所以是没有重载说法的。

- 作为值的函数：函数的本身就是一个变量，所以函数也可以当做值来使用，所以我们不仅可以将函数作为参数传入一个函数中，也可以将函数当成一个函数的
返回，举个栗子：
```
function extend(fn1, arg) {
    return fn1(arg)
}
function sum(arg1) {
    return arg1 + 20
}
console.log(extend(sum,10)) //30
```
这里我们要注意，如果我们要访问一个函数，那直接输入函数名就行了，但是如果我们要运行一个函数，就必须在函数名后加上括号，只要函数名后面有括号，
那么函数就会被运行，我们再举个栗子：
```
function extend(arg) {
    return  function sum() {
        return arg + 20
    }
}
console.log(extend(10)()) //30
```
这里，如果我们只写`extend(10)`那么打印出来就只会是一个函数，必须要再后面再加个括号让它运行。

- 函数内部的属性：

`arguments`：这个属性我们在前面接触过，它是一个类数组，里面保存着传入函数的参数

`this`：this引用的是函数据以执行的环境对象；

- 函数的属性和方法：

`length`：表示函数的arguments（参数）的个数。

`prototype`：对于es中的引用类型而言，prototype中保存的是他们的实例属性，也就是说`toString`、`valueOf`等方法，都是保存在`prototype`中，只
是通过他们的实例来访问罢了，在创建自定义属性和实现继承时，prototype也是异常重要的，而且在es5中prototype中的属性是不可枚举的，所以在使用
for-in的时候无法遍历出prototype中的属性。

每个函数都包含两个非继承而来的方法`apply`、`call`，这两个方法的作用都是将函数放进特定的执行环境中执行，也即是改变`this`的指向。

`apply`：第一个参数是绑定执行环境（this的指向），第二个参宿是一个数组，里面存放的是函数需要传入的值，也就是arguments对象
```
function sum(num1,num2) {
    return num1+num2
}
function test(num1,num2) {
    return sum.apply(this,arguments)
}
console.log(test(1,2))
```
`call`：它接受的参数完全跟`apply`相同，只是它必须将传入的每个参数都一一列出来
```
function sum(num1,num2) {
    return num1+num2
}
function test(num1,num2) {
    return sum.apply(this,num1,num2)
}
console.log(test(1,2))
```
`bind`：创建一个函数的实例，其this值会被绑定到传给bind函数的值,不过它返回的是一个函数，所以还需要触发
```
function sum() {
    alert(this.color)
}
let color = 'white'
let o = {
    color:'red'
};

sum.bind(o)();
```
- 基本包装类型，为了便于操作基本操作类型的值，js还提供了三个特殊的引用类型，`Boolean`、`Number`、`String`，每当读取一个对应的基本类型的值的
时候，就会在后台生成了对应的基本包装类型对象，从而让我们能够调用对应的方法，那么，包装对象跟其他对象有什么区别呢?
```
let test = "some text";
test.substring(0,2)  //so
```
在前面我们说过，字符串只是一个基本类型，它本来是没有方法的，那为什么又有substring方法了呢？原因就是js在后台给我们做了处理，当我们执行`test.substring(0,2)`
这个方法的时候，实际上后台帮我们做了三个事情，第一个事情是将字符串变为一个String的实例，第二个事情是调用实例中的那个`substring`方法，最后将新建的对象销毁
```
let test3 = new String("some text");
test2 = test3.substring(0,2);
test3 = null;  
```
将这些基本类型的值当成引用类型调用的时候，都会出现如上的过程，一定要注意，这个基本包装类型对象会被销毁！所以不能用它来储存各种东西,当然，我
们可以使用Boolean等显式的创建基本包装类型，但是我们并不推荐这样做，因为这样会让我们无法区分哪些是基本类型和基本包装类型

- Boolean类型：我们在使用boolean包装类型的时候，一定注意尽量不要显示的创建它
```
let boolen = new Boolean(false);
console.log(boolen&&true)  //true
```
上面这个例子是因为我们检测的是boolen对象而不是里面的值，因为boolen对象存在，所以为`true`，所以我们永远也不要使用boolean对象！

- Number类型：它也重写了`valueOf` `toLocaleString` `toString`  方法  它还具有一个（基本类型也具有）`toFixed`方法，这个方法传入一个数
字，返回指定小数位的数字，如果本来就有大于本来小数位的位数，那就会进行四舍五入，当然我们也不要显式的创建数值类型，这样会给我们使用typeof
判断的时候带来困扰

- String类型，string类型都包含有一个length属性，表示字符串中包含的字符数，当然这个字符数是按照数量来计算的，不是按照字节来计算的，字符串中
具有很多实用的方法：

`charAt()`；传入一个数字，返回指定位置的单个字符

`charCodeAt()`：传入一个数字，返回指定位置的字符编码

在es5中我们可以用访问数组项目的方法来访问字符串的对应项目：
```
let boolen = "test"
console.log( boolen[2])  //s
```

`concat`：将两个字符串拼接，当然我们拼接字符串一般还是使用 `+`操作符

以下三个方法操作字符串，但是**不会**改变字符串本身的值

`slice`、`substring`：接受两个参数，第一个参数表明起始位置，第二个参数表明结束位置，第二个参数非必填，没有填的时候默认是字符串的末尾，它返回起始位置和
结束位置的字符，注意不会包括结束位置

`substr`：接受两个参数，第一个参数为起始位置，第二个参数是返回多少个字符

当传递负值的时候，