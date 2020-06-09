package com.github.psambit9791.jdsp;

import com.github.psambit9791.jdsp.transform.Hilbert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestHilbert {

    private double[] signal1 = {1.   ,  0.702, -0.168, -1.023, -1.148, -0.311,  0.884,  1.373,
            0.596, -0.816, -1.471, -0.607,  0.939,  1.461,  0.303, -1.208,
            -1.219,  0.301,  1.374,  0.576, -0.957, -1.051,  0.363,  1.12 ,
            0.127, -0.955, -0.418,  0.723,  0.534, -0.526, -0.542,  0.397,
            0.499, -0.337, -0.438,  0.332,  0.372, -0.373, -0.292,  0.449,
            0.172, -0.541,  0.026,  0.593, -0.322, -0.502,  0.666,  0.152,
            -0.866,  0.454,  0.633, -1.021,  0.16 ,  0.984, -1.083, -0.023,
            1.18 , -1.191,  0.035,  1.193, -1.382,  0.397,  0.909, -1.499,
            0.979,  0.202, -1.196,  1.392, -0.759, -0.245,  1.033, -1.238,
            0.852, -0.146, -0.529,  0.912, -0.921,  0.63 , -0.196, -0.221,
            0.512, -0.635,  0.602, -0.459,  0.258, -0.046, -0.147,  0.304,
            -0.418,  0.49 , -0.524,  0.525, -0.497,  0.446, -0.377,  0.296,
            -0.207,  0.116, -0.028, -0.053,  0.123, -0.176,  0.21 , -0.219,
            0.201, -0.15 ,  0.063,  0.061, -0.224,  0.422, -0.646,  0.884,
            -1.115,  1.311, -1.442,  1.475, -1.384,  1.154, -0.791,  0.328,
            0.177, -0.641,  0.978, -1.112,  1.007, -0.681,  0.214,  0.268,
            -0.626,  0.755, -0.62 ,  0.281,  0.13 , -0.449,  0.548, -0.388,
            0.045,  0.314, -0.498,  0.387, -0.017, -0.402,  0.573, -0.315,
            -0.248,  0.686, -0.566, -0.122,  0.804, -0.758};

    private double[] signal2 = {0.   ,  0.   ,  0.   ,  0.   , -0.   , -0.   , -0.   , -0.   ,
            -0.   , -0.   , -0.   , -0.   ,  0.   ,  0.   ,  0.   ,  0.   ,
            0.   ,  0.   ,  0.   , -0.   , -0.   , -0.   , -0.   , -0.   ,
            -0.   , -0.   , -0.   ,  0.   ,  0.   ,  0.   ,  0.   ,  0.   ,
            0.   ,  0.   , -0.   , -0.001, -0.002, -0.003, -0.004, -0.005,
            -0.004, -0.001,  0.004,  0.011,  0.02 ,  0.028,  0.032,  0.03 ,
            0.017, -0.007, -0.042, -0.082, -0.12 , -0.143, -0.141, -0.102,
            -0.025,  0.085,  0.213,  0.331,  0.409,  0.42 ,  0.342,  0.174,
            -0.065, -0.336, -0.587, -0.759, -0.805, -0.701, -0.453, -0.098,
            0.298,  0.659,  0.91 ,  1.   ,  0.91 ,  0.659,  0.298, -0.098,
            -0.453, -0.701, -0.805, -0.759, -0.587, -0.336, -0.065,  0.174,
            0.342,  0.42 ,  0.409,  0.331,  0.213,  0.085, -0.025, -0.102,
            -0.141, -0.143, -0.12 , -0.082, -0.042, -0.007,  0.017,  0.03 ,
            0.032,  0.028,  0.02 ,  0.011,  0.004, -0.001, -0.004, -0.005,
            -0.004, -0.003, -0.002, -0.001, -0.   ,  0.   ,  0.   ,  0.   ,
            0.   ,  0.   ,  0.   ,  0.   , -0.   , -0.   , -0.   , -0.   ,
            -0.   , -0.   , -0.   , -0.   ,  0.   ,  0.   ,  0.   ,  0.   ,
            0.   ,  0.   ,  0.   , -0.   , -0.   , -0.   , -0.   , -0.   ,
            -0.   , -0.   , -0.   ,  0.   ,  0.   ,  0.};

    @Test
    public void testHilbertAmplitudeEnvelope1() {
        double[] result = {1.1989, 1.1646, 0.9854, 1.2155, 1.2632, 1.2619, 1.3624, 1.3877,
                1.4103, 1.4623, 1.4759, 1.4838, 1.5007, 1.5   , 1.4901, 1.4781,
                1.4527, 1.418 , 1.3851, 1.3462, 1.2931, 1.2382, 1.1861, 1.1246,
                1.059 , 1.0026, 0.9422, 0.8706, 0.8107, 0.7666, 0.7117, 0.6481,
                0.6086, 0.5892, 0.5551, 0.5122, 0.4989, 0.5134, 0.5152, 0.4998,
                0.506 , 0.5515, 0.5998, 0.6217, 0.6364, 0.6873, 0.7724, 0.8448,
                0.8804, 0.9095, 0.9753, 1.0734, 1.1601, 1.206 , 1.2227, 1.2531,
                1.3229, 1.4084, 1.468 , 1.4808, 1.4591, 1.4413, 1.457 , 1.4992,
                1.5359, 1.5358, 1.4887, 1.4098, 1.3284, 1.272 , 1.2506, 1.2492,
                1.2421, 1.2089, 1.1412, 1.0411, 0.9239, 0.8073, 0.7105, 0.6506,
                0.6288, 0.6366, 0.6564, 0.6757, 0.6886, 0.6892, 0.6828, 0.6647,
                0.6416, 0.611 , 0.5777, 0.5393, 0.4973, 0.4521, 0.4032, 0.3537,
                0.3004, 0.2499, 0.1999, 0.1657, 0.1525, 0.1763, 0.2291, 0.2971,
                0.3801, 0.4681, 0.5672, 0.6678, 0.7801, 0.8902, 1.0081, 1.1225,
                1.2382, 1.3442, 1.4421, 1.5246, 1.5853, 1.6253, 1.6288, 1.6078,
                1.5419, 1.451 , 1.3211, 1.1749, 1.0172, 0.8691, 0.7664, 0.7105,
                0.7234, 0.7591, 0.7877, 0.7976, 0.7501, 0.6779, 0.5609, 0.4438,
                0.3872, 0.4046, 0.5023, 0.6052, 0.6396, 0.6517, 0.5744, 0.4889,
                0.548 , 0.6863, 0.8547, 1.0855, 0.9561, 0.7818};

        Hilbert h = new Hilbert(this.signal1);
        h.hilbert_transform();
        h.get_output();
        double[] out = h.get_amplitude_envelope();
        Assertions.assertArrayEquals(result, out, 0.001);
    }

    @Test
    public void testHilbertAmplitudeEnvelope2() {
        double[] result = {0.    , 0.    , 0.    , 0.    , 0.    , 0.    , 0.    , 0.    ,
                0.    , 0.    , 0.    , 0.    , 0.    , 0.    , 0.    , 0.    ,
                0.    , 0.0001, 0.    , 0.0001, 0.    , 0.0001, 0.    , 0.0001,
                0.0001, 0.0001, 0.0001, 0.0001, 0.0001, 0.0002, 0.0002, 0.0003,
                0.0004, 0.0005, 0.001 , 0.0019, 0.0023, 0.003 , 0.0041, 0.0059,
                0.008 , 0.01  , 0.0131, 0.0167, 0.0221, 0.028 , 0.0349, 0.0446,
                0.0552, 0.0684, 0.0836, 0.1015, 0.1227, 0.1462, 0.1741, 0.2046,
                0.2383, 0.2766, 0.3182, 0.362 , 0.409 , 0.4597, 0.5116, 0.5646,
                0.6183, 0.6723, 0.7255, 0.7758, 0.8231, 0.8665, 0.9057, 0.9385,
                0.9651, 0.9847, 0.996 , 1.    , 0.996 , 0.9847, 0.9651, 0.9385,
                0.9057, 0.8665, 0.8231, 0.7758, 0.7255, 0.6723, 0.6183, 0.5646,
                0.5116, 0.4597, 0.409 , 0.362 , 0.3182, 0.2766, 0.2383, 0.2046,
                0.1741, 0.1462, 0.1227, 0.1015, 0.0836, 0.0684, 0.0552, 0.0446,
                0.0349, 0.028 , 0.0221, 0.0167, 0.0131, 0.01  , 0.008 , 0.0059,
                0.0041, 0.003 , 0.0023, 0.0019, 0.001 , 0.0005, 0.0004, 0.0003,
                0.0002, 0.0002, 0.0001, 0.0001, 0.0001, 0.0001, 0.0001, 0.0001,
                0.    , 0.0001, 0.    , 0.0001, 0.    , 0.0001, 0.    , 0.    ,
                0.    , 0.    , 0.    , 0.    , 0.    , 0.    , 0.    , 0.    ,
                0.    , 0.    , 0.    , 0.    , 0.    , 0.};

        Hilbert h = new Hilbert(this.signal2);
        h.hilbert_transform();
        double[] out = h.get_amplitude_envelope();
        Assertions.assertArrayEquals(result, out, 0.001);
    }

    @Test
    public void testHilbertInstantaneousPhase1() {
        double[] result = {-0.584,   0.924,   1.742,   2.571,   3.572,   4.463,   5.418,
                6.429,   7.418,   8.446,   9.506,  10.574,  11.672,  12.795,
                13.932,  15.094,  16.283,  17.493,  18.723,  19.978,  21.254,
                22.548,  23.873,  25.223,  26.583,  27.965,  29.385,  30.825,
                32.268,  33.743,  35.263,  36.788,  38.309,  39.879,  41.502,
                43.117,  44.712,  46.366,  48.092,  49.811,  51.489,  53.212,
                55.021,  56.854,  58.65 ,  60.442,  62.301,  64.222,  66.155,
                68.067,  69.98 ,  71.943,  73.966,  76.015,  78.057,  80.092,
                82.151,  84.26 ,  86.418,  88.599,  90.78 ,  92.956,  95.145,
                97.373,  99.651, 101.97 , 104.31 , 106.655, 108.993, 111.333,
                113.696, 116.105, 118.566, 121.072, 123.611, 126.167, 128.726,
                131.271, 133.797, 136.313, 138.849, 141.443, 144.103, 146.831,
                149.61 , 152.434, 155.292, 158.175, 161.083, 164.003, 166.939,
                169.877, 172.824, 175.765, 178.708, 181.633, 184.543, 187.407,
                190.207, 192.882, 195.411, 197.974, 200.651, 203.462, 206.332,
                209.242, 212.169, 215.108, 218.049, 220.988, 223.928, 226.859,
                229.786, 232.701, 235.611, 238.505, 241.393, 244.263, 247.122,
                249.962, 252.783, 255.582, 258.348, 261.081, 263.752, 266.365,
                268.889, 271.361, 273.843, 276.356, 278.937, 281.533, 284.14 ,
                286.732, 289.241, 291.661, 293.855, 295.992, 298.321, 300.716,
                303.19 , 305.641, 307.945, 310.147, 312.119, 314.132, 316.454,
                318.759, 321.014, 323.832};

        Hilbert h = new Hilbert(this.signal1);
        h.hilbert_transform();
        double[] out = h.get_instantaneous_phase();
        Assertions.assertArrayEquals(result, out, 0.001);
    }

    @Test
    public void testHilbertInstantaneousPhase2() {
        double[] result = {-1.056,  1.571,  1.571,  1.571,  1.571,  1.571,  1.571,  1.571,
                1.571,  1.571,  1.571,  1.571,  1.571,  1.571,  1.571,  1.571,
                1.571,  1.571,  1.571,  1.571,  1.571,  1.571,  1.571,  1.571,
                1.571,  1.571,  1.571,  1.571,  1.571,  1.571,  1.571,  1.571,
                1.571,  1.571,  1.571,  2.141,  2.629,  2.961,  3.326,  3.694,
                4.189,  4.612,  5.023,  5.431,  5.843,  6.293,  6.695,  7.116,
                7.541,  7.957,  8.38 ,  8.795,  9.216,  9.634, 10.051, 10.474,
                10.89 , 11.308, 11.729, 12.149, 12.566, 12.985, 13.405, 13.824,
                14.242, 14.661, 15.08 , 15.499, 15.918, 16.336, 16.755, 17.174,
                17.593, 18.012, 18.431, 18.85 , 19.268, 19.687, 20.106, 20.525,
                20.944, 21.363, 21.781, 22.2  , 22.619, 23.039, 23.457, 23.875,
                24.294, 24.714, 25.133, 25.55 , 25.97 , 26.391, 26.809, 27.225,
                27.648, 28.065, 28.483, 28.904, 29.319, 29.743, 30.158, 30.584,
                31.004, 31.406, 31.856, 32.268, 32.676, 33.087, 33.51 , 34.005,
                34.373, 34.738, 35.07 , 35.558, 36.128, 36.128, 36.128, 36.128,
                36.128, 36.128, 36.128, 36.128, 36.128, 36.128, 36.128, 36.128,
                36.128, 36.128, 36.128, 36.128, 36.128, 36.128, 36.128, 36.128,
                36.128, 36.128, 36.128, 36.128, 36.128, 36.128, 36.128, 36.128,
                36.128, 36.128, 36.128, 36.128, 36.128, 36.128};

        Hilbert h = new Hilbert(this.signal2);
        h.hilbert_transform();
        double[] out = h.get_instantaneous_phase();
        Assertions.assertArrayEquals(result, out, 0.001);
    }

    @Test
    public void testHilbertInstantaneousFrequency1() {
        double Fs = 150.0;
        double[] result = {36.001, 19.528, 19.791, 23.897, 21.271, 22.799, 24.136, 23.611,
                24.542, 25.306, 25.497, 26.213, 26.81 , 27.144, 27.741, 28.385,
                28.887, 29.364, 29.961, 30.462, 30.892, 31.632, 32.229, 32.468,
                32.993, 33.9  , 34.377, 34.449, 35.213, 36.287, 36.407, 36.311,
                37.481, 38.746, 38.555, 38.078, 39.486, 41.205, 41.038, 40.059,
                41.134, 43.187, 43.76 , 42.876, 42.781, 44.38 , 45.86 , 46.147,
                45.646, 45.67 , 46.863, 48.296, 48.916, 48.749, 48.582, 49.155,
                50.349, 51.518, 52.068, 52.068, 51.948, 52.259, 53.19 , 54.383,
                55.362, 55.863, 55.983, 55.816, 55.863, 56.412, 57.511, 58.752,
                59.826, 60.614, 61.02 , 61.092, 60.757, 60.304, 60.065, 60.543,
                61.927, 63.503, 65.126, 66.344, 67.418, 68.23 , 68.827, 69.423,
                69.71 , 70.092, 70.14 , 70.354, 70.211, 70.259, 69.829, 69.471,
                68.373, 66.845, 63.861, 60.375, 61.187, 63.909, 67.108, 68.516,
                69.471, 69.877, 70.163, 70.211, 70.163, 70.187, 69.972, 69.877,
                69.59 , 69.471, 69.089, 68.946, 68.516, 68.254, 67.8  , 67.346,
                66.821, 66.033, 65.246, 63.765, 62.381, 60.256, 59.015, 59.253,
                59.993, 61.617, 61.975, 62.238, 61.879, 59.898, 57.773, 52.378,
                51.017, 55.601, 57.176, 59.062, 58.513, 55.004, 52.569, 47.078,
                48.057, 55.434, 55.028, 53.834, 67.275};

        Hilbert h = new Hilbert(this.signal1);
        h.hilbert_transform();
        double[] out = h.get_instantaneous_frequency(Fs);
        Assertions.assertArrayEquals(result, out, 0.05);
    }

    @Test
    public void testHilbertInstantaneousFrequency2() {
        double Fs = 150.0;
        double[] result = {62.7167,   0.    ,   0.    ,   0.    ,   0.    ,   0.    ,
                0.    ,   0.    ,   0.    ,   0.    ,   0.    ,   0.    ,
                0.    ,   0.    ,   0.    ,   0.    ,   0.    ,   0.    ,
                0.    ,   0.    ,   0.    ,   0.    ,   0.    ,   0.    ,
                0.    ,   0.    ,   0.    ,   0.    ,   0.    ,   0.    ,
                0.    ,   0.    ,   0.    ,   0.    ,  13.6054,  11.6669,
                7.9164,   8.7161,   8.7758,  11.8173,  10.1103,   9.8143,
                9.7427,   9.831 ,  10.7382,   9.597 ,  10.0411,  10.1485,
                9.9265,  10.1199,   9.8883,  10.0673,   9.9647,   9.9671,
                10.0864,   9.9504,   9.9647,  10.0506,  10.0363,   9.9528,
                9.9957,  10.0291,  10.0005,   9.9933,   9.979 ,  10.0124,
                10.0101,   9.9981,   9.9862,   9.9957,  10.0053,   9.9933,
                10.0101,  10.0005,   9.9957,   9.9933,  10.0005,  10.0101,
                9.9933,  10.0053,   9.9957,   9.9862,   9.9981,  10.0124,
                10.0101,   9.979 ,   9.9933,  10.0029,  10.0268,   9.9957,
                9.9528,  10.0363,  10.0506,   9.9647,   9.9504,  10.0864,
                9.9671,   9.9647,  10.0673,   9.8883,  10.1199,   9.9289,
                10.1461,  10.0411,   9.597 ,  10.7382,   9.831 ,   9.7427,
                9.8143,  10.1127,  11.8149,   8.7758,   8.7161,   7.9164,
                11.6669,  13.6054,   0.    ,   0.    ,   0.    ,   0.    ,
                0.    ,   0.    ,   0.    ,   0.    ,   0.    ,   0.    ,
                0.    ,   0.    ,   0.    ,   0.    ,   0.    ,   0.    ,
                0.    ,   0.    ,   0.    ,   0.    ,   0.    ,   0.    ,
                0.    ,   0.    ,   0.    ,   0.    ,   0.    ,   0.    ,
                0.    ,   0.    ,   0.    ,   0.    ,   0.};

        Hilbert h = new Hilbert(this.signal2);
        h.hilbert_transform();
        double[] out = h.get_instantaneous_frequency(Fs);
        Assertions.assertArrayEquals(result, out, 0.05);
    }
}
