package com.ajayhao.mslab.lambdalab.service;

import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;
import org.neuroph.core.learning.LearningRule;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.nnet.Perceptron;
import org.neuroph.util.TransferFunctionType;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * NeuralService
 * <p>
 * TODO
 *
 * @author Ajay Hao
 * @version 1.0
 * @date 2019/10/14 13:54
 */
@Service
public class NeuralService {

    public void trainingData1() {
        // 建立AND 训练集
        DataSet trainAndSet = new DataSet(2, 1);
        trainAndSet.add(new DataSetRow(new double[]{0, 0}, new double[]{0}));
        trainAndSet.add(new DataSetRow(new double[]{0, 1}, new double[]{0}));
        trainAndSet.add(new DataSetRow(new double[]{1, 0}, new double[]{0}));
        trainAndSet.add(new DataSetRow(new double[]{1, 1}, new double[]{1}));

        // 建立OR训练集
        DataSet trainOrSet = new DataSet(2, 1);
        trainOrSet.add(new DataSetRow(new double[]{0, 0}, new double[]{0}));
        trainOrSet.add(new DataSetRow(new double[]{0, 1}, new double[]{1}));
        trainOrSet.add(new DataSetRow(new double[]{1, 0}, new double[]{1}));
        trainOrSet.add(new DataSetRow(new double[]{1, 1}, new double[]{1}));

        // 建立XOR训练集
        DataSet trainXorSet = new DataSet(2, 1);
        trainXorSet.add(new DataSetRow(new double[]{0, 0}, new double[]{0}));
        trainXorSet.add(new DataSetRow(new double[]{0, 1}, new double[]{1}));
        trainXorSet.add(new DataSetRow(new double[]{1, 0}, new double[]{1}));
        trainXorSet.add(new DataSetRow(new double[]{1, 1}, new double[]{0}));


        // 建立感知机
        NeuralNetwork myPerceptron = new Perceptron(2, 1);
        // 训练AND集
        myPerceptron.learn(trainAndSet);
        System.out.println("测试感知机AND集训练结果：");
        // myPerceptron.save("D:/AND_learn_result.txt");
        testNeuralNetwork(myPerceptron, trainAndSet);
        // 训练OR集
        myPerceptron.learn(trainOrSet);
        System.out.println("测试感知机OR集训练结果：");
        // myPerceptron.save("D:/OR_learn_result.txt");
        testNeuralNetwork(myPerceptron, trainOrSet);
        // 训练XOR集
        // 由于XOR输入输出情况线性不可分，将无法完成训练
        /*myPerceptron.learn(trainXorSet);
        System.out.println("测试感知机XOR集训练结果：");
        myPerceptron.save("XOR_learn_result.nnet");
        testNeuralNetwork(myPerceptron, trainXorSet);*/
        // 多层感知机
        MultiLayerPerceptron myMlPerception = new MultiLayerPerceptron(TransferFunctionType.TANH, 2, 30, 1);
        myMlPerception.learn(trainXorSet);
        System.out.println("测试感知机XOR集训练结果：");
        // myMlPerception.save("D:/XOR_learn_result.txt");
        testNeuralNetwork(myMlPerception, trainXorSet);
    }

    public void trainXor(int hiddenLayerNum) {

        int inputLayerNum = 2;
        int outputLayerNum = 1;

        // 建立XOR训练集
        DataSet trainXorSet = new DataSet(2, 1);
        trainXorSet.add(new DataSetRow(new double[]{0, 0}, new double[]{0}));
        trainXorSet.add(new DataSetRow(new double[]{0, 1}, new double[]{1}));
        trainXorSet.add(new DataSetRow(new double[]{1, 0}, new double[]{1}));
        trainXorSet.add(new DataSetRow(new double[]{1, 1}, new double[]{0}));


        // 建立感知机
        NeuralNetwork myPerceptron = new Perceptron(2, 1);
        // 训练XOR集
        // 多层感知机
        MultiLayerPerceptron myMlPerception = new MultiLayerPerceptron(TransferFunctionType.TANH, inputLayerNum, hiddenLayerNum, outputLayerNum);
        myMlPerception.learn(trainXorSet);
        System.out.println("测试感知机XOR集训练结果：");
        // myMlPerception.save("D:/XOR_learn_result.txt");
        testNeuralNetwork(myMlPerception, trainXorSet);
    }


    private void testNeuralNetwork(NeuralNetwork nnet, DataSet tset) {
        for (DataSetRow dataRow : tset.getRows()) {
            nnet.setInput(dataRow.getInput());
            nnet.calculate();
            double[ ] networkOutput = nnet.getOutput();
            System.out.print("Input: " + Arrays.toString(dataRow.getInput()) );
            System.out.println(" Output: " + Arrays.toString(networkOutput) );
        }
    }

    private void createNetwork(int inputNeuronsCount, int outputNeuronsCount, TransferFunctionType transferFunctionType) {
        //设置神经网络类型， 此处设置为感知机

    }

}
