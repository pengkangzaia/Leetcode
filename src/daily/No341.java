package daily;

import myanswer.stack.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @FileName: No341.java
 * @Description: No341.java类说明
 * @Author: admin
 * @Date: 2021/3/23 9:39
 */
public class No341 {

    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     *
     *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     *     public boolean isInteger();
     *
     *     // @return the single integer that this NestedInteger holds, if it holds a single integer
     *     // Return null if this NestedInteger holds a nested list
     *     public Integer getInteger();
     *
     *     // @return the nested list that this NestedInteger holds, if it holds a nested list
     *     // Return null if this NestedInteger holds a single integer
     *     public List<NestedInteger> getList();
     * }
     */
    public class NestedIterator implements Iterator<Integer> {

        ArrayList<Integer> list = new ArrayList<>();
        int idx = 0;


        public NestedIterator(List<NestedInteger> nestedList) {
            if (nestedList == null || nestedList.size() == 0) {
                return;
            }
            for (NestedInteger nestedInteger : nestedList) {
                dfs(nestedInteger);
            }
        }

        private void dfs(NestedInteger nestedInteger) {
            if (nestedInteger == null) {
                return;
            }
            if (nestedInteger.isInteger()) {
                list.add(nestedInteger.getInteger());
            } else {
                List<NestedInteger> list = nestedInteger.getList();
                if (list == null || list.size() == 0) {
                    return;
                }
                for (NestedInteger integer : list) {
                    dfs(integer);
                }
            }
        }


        @Override
        public Integer next() {
            return list.get(idx++);
        }

        @Override
        public boolean hasNext() {
            return idx < list.size();
        }
    }

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */


}
