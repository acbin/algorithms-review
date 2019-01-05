package basic.structure.array;


/**
 * 数组封装类
 * @author bingo
 * @since 2018/9/11
 */

public class Array<E> {
    private E[] data;
    private int size;

    /**
     * 有参构造函数
     * @param capacity
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /** 无参构造函数，默认容量10 */
    public Array() {
        this(10);
    }

    /**
     * 返回当前数组元素个数
     * @return 元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 返回数组容量
     * @return 容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 判断数组是否为空(没有元素)
     * @return boolean
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向指定位置添加元素
     * @param index 位置
     * @param e 元素值
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add fail. Require index >=0 && index <= size.");
        }

        // 数组已满，进行扩容
        if (data.length == size) {
            resize(size * 2);
        }

        for (int i = size - 1; i >= index; --i) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        ++size;
    }

    /**
     * 数组扩容
     * @param newCapacity 新的容量
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; ++i) {
            newData[i] = data[i];
        }
        data = newData;

    }

    /**
     * 在数组第一个位置上插入元素
     * @param e 元素值
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在当前数组第一个空闲位置插入元素
     * @param e 元素值
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获取某个位置的元素值
     * @param index 位置
     * @return 某个位置的元素值
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get fail. Index is illegal.");
        }
        return data[index];
    }

    /**
     * 获取第一个元素值
     * @return 元素值
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取最后一个元素值
     * @return 元素值
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 设置某个位置对应的元素值
     * @param index 位置
     * @param e 元素值
     */
    public void set(int index, E e) {
        if (index <0 || index >= size) {
            throw new IllegalArgumentException("Set fail. Index is illegal.");
        }
        data[index] = e;
    }

    /**
     * 判断数组是否包含某个元素
     * @param e 元素
     * @return boolean
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; ++i) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中某个元素的位置，找不到则返回-1
     * @param e 元素
     * @return 位置
     */
    public int find(E e) {
        for (int i = 0; i < size; ++i) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 从数组中删除指定位置的元素
     * @param index 位置
     * @return 删除的元素
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove fail. Index is illegal.");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; ++i) {
            data[i - 1] = data[i];
        }
        // 让 jvm 进行垃圾回收
        data[size] = null;
        --size;

        // 数组缩容 (lazy，防止复杂度震荡)、并且确保 data.length/2 不等于0
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    /**
     * 从数组中删除第一个元素
     * @return 删除的元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 从数组中删除最后一个元素
     * @return 删除的元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 从数组中删除指定元素
     * @param e 待删除的元素
     */
    public boolean removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("Array{data=[");
        for (int i = 0; i < size; ++i) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("], size=").append(size).append("}");
        return res.toString();
    }

    public static void main(String[] args) {
        Array<Integer> array = new Array<>(20);
        int initSize = 10;
        for (int i = 0; i < initSize; ++i) {
            array.addLast(i);
        }
        System.out.println(array);
        array.add(1, 100);
        System.out.println(array);

        array.remove(2);
        array.removeElement(8);
        System.out.println(array);

    }
}