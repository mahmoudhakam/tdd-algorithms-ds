package com.microservices.test.blind75;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BestTimeToBuyAndSellStocksTest {

    BestTimeToBuyAndSellStocks bestTimeToBuyAndSellStocks;

    @BeforeEach
    void setUp() {
        bestTimeToBuyAndSellStocks = new BestTimeToBuyAndSellStocks();
    }

    /**
     * Input: [3, 2, 6, 5, 0, 3]
     * Expected Output: 4
     * Justification: Buy the stock on day 2 (price = 2) and sell it on day 3 (price = 6). Profit = 6 - 2 = 4.
     */

    @Test
    @DisplayName("givenArrayOfStockPrices_whenStocksRaise_thenSellAndReturnProfit")
    void bestTimeToBuyAndSellStocks() {
//Arrange
        int[] nums1 = {3, 2, 6, 5, 0, 3};
        int expectedProfit = 4;
//Act
        int profit = bestTimeToBuyAndSellStocks.bestTimeToBuyAndSellStocks(nums1);
//Assert
        assertEquals(expectedProfit, profit);
    }
}