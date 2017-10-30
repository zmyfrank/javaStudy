package collection;

import charactor.Hero;

/**
 * @author Frank
 */
public interface Stack {
    /**
     * push 将英雄推入最后位置
     *
     * @param h 推入的英雄
     */
    public void push(Hero h);

    /**
     * pull 将最上层英雄取出
     *
     * @return 返回最上层英雄
     */
    public Hero pull();

    /**
     * peek 取出英雄
     * @return 返回英雄
     */
    public Hero peek();
}
