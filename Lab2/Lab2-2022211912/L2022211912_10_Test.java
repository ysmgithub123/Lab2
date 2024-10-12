import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * 测试类L2022211912_10_Test.java
 *
 * 测试用例设计原则：
 * 1. 等价类划分：分为负数和正数的分数相加、相减。
 * 2. 边界值分析：包括不同长度的分子和分母组合，测试边界情况。
 * 3. 错误猜测法：使用容易出现的问题情况，比如相加为0，或分母为1的情况。
 */
public class L2022211912_10_Test {

    private Solution10 solution;

    @Before
    public void setUp() {
        // 初始化 Solution10 对象
        solution = new Solution10();
    }

    /**
     * 测试方法：testEqualFractions()
     * 测试目的：测试两个分数相加为零的情况。
     * 测试用例：
     * - 输入："-1/2+1/2"
     * - 预期输出："0/1"
     */
    @Test
    public void testEqualFractions() {
        assertEquals("0/1", solution.fractionAddition("-1/2+1/2"));
    }

    /**
     * 测试方法：testMultipleFractionsAddition()
     * 测试目的：测试多个分数相加的情况。
     * 测试用例：
     * - 输入："-1/2+1/2+1/3"
     * - 预期输出："1/3"
     */
    @Test
    public void testMultipleFractionsAddition() {
        assertEquals("1/3", solution.fractionAddition("-1/2+1/2+1/3"));
    }

    /**
     * 测试方法：testNegativeResult()
     * 测试目的：测试相减后为负数的情况。
     * 测试用例：
     * - 输入："1/3-1/2"
     * - 预期输出："-1/6"
     */
    @Test
    public void testNegativeResult() {
        assertEquals("-1/6", solution.fractionAddition("1/3-1/2"));
    }

    /**
     * 测试方法：testIntegerResult()
     * 测试目的：测试最终结果为整数的情况。
     * 测试用例：
     * - 输入："4/2+2/1"
     * - 预期输出："4/1"
     */
    @Test
    public void testIntegerResult() {
        assertEquals("4/1", solution.fractionAddition("4/2+2/1"));
    }

    /**
     * 测试方法：testBoundaryValues()
     * 测试目的：测试边界值，处理较大分子分母。
     * 测试用例：
     * - 输入："1/10+9/10"
     * - 预期输出："1/1"
     */
    @Test
    public void testBoundaryValues() {
        assertEquals("1/1", solution.fractionAddition("1/10+9/10"));
    }
}
