package almostperfect;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlmostPerfectTest {

    @Test
    void sumAllDivisors() {
        List<Integer> perfectNumbers = new ArrayList<>(Arrays.asList(6, 28, 496, 8128, 33550336));

        for (Integer p : perfectNumbers) {
            assertEquals(p, AlmostPerfect.sumAllDivisors(p));
        }
        assertEquals(652, AlmostPerfect.sumAllDivisors(650));

        List<Integer> first650 = new ArrayList<>(Arrays.asList(1, 1, 1, 3, 1, 6, 1, 7, 4, 8, 1, 16, 1, 10, 9, 15, 1,
                21, 1, 22, 11, 14, 1, 36, 6, 16, 13, 28, 1, 42, 1, 31, 15, 20, 13, 55, 1, 22, 17, 50, 1, 54, 1, 40,
                33, 26, 1, 76, 8, 43, 21, 46, 1, 66, 17, 64, 23, 32, 1, 108, 1, 34, 41, 63, 19, 78, 1, 58, 27, 74, 1,
                123, 1, 40, 49, 64, 19, 90, 1, 106, 40, 44, 1, 140, 23, 46, 33, 92, 1, 144, 21, 76, 35, 50, 25, 156,
                1, 73, 57, 117, 1, 114, 1, 106, 87, 56, 1, 172, 1, 106, 41, 136, 1, 126, 29, 94, 65, 62, 25, 240, 12,
                64, 45, 100, 31, 186, 1, 127, 47, 122, 1, 204, 27, 70, 105, 134, 1, 150, 1, 196, 51, 74, 25, 259, 35,
                76, 81, 118, 1, 222, 1, 148, 81, 134, 37, 236, 1, 82, 57, 218, 31, 201, 1, 130, 123, 86, 1, 312, 14,
                154, 89, 136, 1, 186, 73, 196, 63, 92, 1, 366, 1, 154, 65, 176, 43, 198, 29, 148, 131, 170, 1, 316, 1,
                100, 141, 203, 1, 270, 1, 265, 71, 104, 37, 300, 47, 106, 105, 226, 31, 366, 1, 166, 75, 110, 49,
                384, 39, 112, 77, 284, 31, 234, 1, 280, 178, 116, 1, 332, 1, 202, 153, 218, 1, 312, 53, 184, 83, 194,
                1, 504, 1, 157, 121, 190, 97, 258, 33, 232, 87, 218, 1, 476, 35, 130, 177, 255, 1, 270, 45, 328, 129,
                134, 1, 456, 59, 214, 93, 208, 1, 450, 1, 286, 175, 140, 97, 396, 1, 142, 137, 440, 1, 294, 1, 220,
                195, 218, 49, 531, 18, 250, 101, 226, 1, 390, 65, 274, 183, 152, 37, 568, 51, 154, 105, 316, 67, 396,
                1, 364, 107, 266, 1, 528, 1, 160, 309, 244, 1, 330, 41, 442, 111, 254, 37, 523, 109, 166, 113, 302,
                55, 534, 1, 256, 161, 170, 73, 656, 1, 211, 117, 416, 43, 438, 57, 316, 231, 176, 1, 492, 1, 394, 209,
                404, 1, 366, 77, 274, 219, 182, 1, 810, 20, 184, 169, 420, 79, 378, 1, 376, 177, 314, 61, 524, 1,
                274, 249, 344, 43, 582, 1, 460, 131, 194, 1, 636, 191, 196, 185, 298, 1, 618, 41, 463, 135, 200, 85,
                696, 1, 202, 241, 561, 1, 414, 45, 310, 321, 314, 49, 672, 1, 346, 141, 316, 67, 522, 89, 466, 143,
                302, 1, 924, 1, 214, 201, 386, 133, 438, 69, 328, 243, 362, 1, 808, 1, 334, 285, 334, 43, 450, 1, 640,
                300, 314, 1, 620, 95, 226, 153, 568, 1, 759, 53, 346, 155, 230, 217, 744, 1, 232, 261, 548, 1, 690,
                1, 466, 303, 236, 1, 806, 75, 394, 161, 428, 55, 486, 145, 532, 225, 242, 1, 1032, 51, 244, 285, 447,
                103, 606, 1, 442, 167, 536, 1, 684, 47, 346, 441, 496, 79, 510, 1, 592, 171, 254, 1, 1056, 107, 358,
                225, 388, 1, 786, 81, 511, 287, 260, 109, 716, 59, 394, 177, 740, 1, 648, 1, 400, 467, 266, 49, 960,
                24, 442, 249, 588, 55, 546, 113, 484, 183, 272, 145, 1140, 1, 274, 185, 590, 115, 798, 1, 418, 257,
                566, 49, 888, 87, 280, 357, 424, 1, 690, 57, 928, 303, 284, 1, 780, 119, 286, 401, 512, 1, 870, 1,
                604, 195, 434, 169, 1075, 1, 343, 197, 680, 91, 594, 65, 526, 507, 296, 1, 1008, 51, 490, 201, 586, 1,
                846, 269, 454, 203, 410, 1, 1260, 1, 454, 281, 460, 193, 618, 1, 652, 351, 506, 61, 1026, 1, 310,
                393, 824, 1, 630, 1, 724, 339, 314, 97, 1112, 156, 316, 333, 478, 55, 1242, 1, 568, 215, 320, 133,
                876, 161, 442, 297, 890, 1, 654, 1, 700, 411, 434, 1, 1167, 71, 652));

        for (int i = 0; i < 650; i++) {
            assertEquals(first650.get(i), AlmostPerfect.sumAllDivisors(i+1));
        }
    }

    @Test
    void calcPerfectNumber() {
        assertEquals("perfect", AlmostPerfect.calcPerfectNumber(6));
        assertEquals("perfect", AlmostPerfect.calcPerfectNumber(28));
        assertEquals("perfect", AlmostPerfect.calcPerfectNumber(496));
        assertEquals("perfect", AlmostPerfect.calcPerfectNumber(8128));
        assertEquals("perfect", AlmostPerfect.calcPerfectNumber(33550336));

        for (Integer p : AlmostPerfect.almostPerfect) {
            assertEquals("almost perfect", AlmostPerfect.calcPerfectNumber(p));
        }

        for (int i = 536870913; i < 536870913 + 100000; i++) {
            assertEquals("not perfect", AlmostPerfect.calcPerfectNumber(i));
        }

        assertEquals("not perfect", AlmostPerfect.calcPerfectNumber(65));
    }
}
