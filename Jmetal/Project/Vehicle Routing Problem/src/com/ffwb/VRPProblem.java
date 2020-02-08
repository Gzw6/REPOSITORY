package com.ffwb;

import java.util.List;
import java.util.ArrayList;

import org.uma.jmetal.problem.impl.AbstractDoubleProblem;
import org.uma.jmetal.solution.DoubleSolution;

public class VRPProblem extends AbstractDoubleProblem{
	
	VRPProblem problem;
	int k;//输入变量，最多可使用的车辆数
	double[][] vehicleInfoMatrix;// K下标从1开始到K，0列表示车的最大载重量，1列表示车行驶的最大距离，2列表示速度
	
	public VRPProblem() {
		this(30);
	}

	//该构造函数包含设置决策变量个数 优化目标函数个数 约束条件个数 还可以命名问题
	public VRPProblem(Integer numberOfVariables) {
		setNumberOfVariables(numberOfVariables);
		setNumberOfObjectives(2);
		setNumberOfConstraints(5);
		setName("Problem");
	
	
	List<Double> lowerLimit= new ArrayList<>(getNumberOfVariables()) ;
    List<Double> upperLimit = new ArrayList<>(getNumberOfVariables()) ;
    
    //这一步是设置决策变量的定义域为{1,0}
    for (int i = 0; i < problem.getNumberOfVariables(); i++) {
		lowerLimit.add(0.0);
		upperLimit.add(1.0);
      }
    	setLowerLimit(lowerLimit);
    	setUpperLimit(upperLimit);
	}

	//该函数包含了优化目标函数的实现过程，由Algorithm.evlataionPopulation()调用
	@Override
	public void evaluate(DoubleSolution solution) {
		double[] f = new double[getNumberOfObjectives()];
		
		f[0] = solution.getVariableValue(0);
		
		
	}

}
