package myanswer.stack;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @FileName: NestedIterator.java
 * @Description: No341,扁平化嵌套迭代器
 * @Author: admin
 * @Date: 2020/11/14 14:54
 */
public class NestedIterator implements Iterator<Integer> {

    List<Integer> res;
    Iterator<Integer> it;

    public NestedIterator(List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) {
            dfs(nestedInteger);
        }
        this.it = res.iterator();
    }

    private void dfs(NestedInteger nestedInteger) {
        if (nestedInteger.isInteger()) {
            res.add(nestedInteger.getInteger());
        }
        for (NestedInteger integer : nestedInteger.getList()) {
            dfs(integer);
        }
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    @Override
    public Integer next() {
        return it.next();
    }
}
