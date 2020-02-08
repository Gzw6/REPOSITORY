package com.ffwb;

import java.util.Map;

import org.uma.jmetal.problem.DoubleProblem;
import org.uma.jmetal.solution.DoubleSolution;
import org.uma.jmetal.solution.Solution;
import org.uma.jmetal.solution.impl.AbstractGenericSolution;
import org.uma.jmetal.util.pseudorandom.JMetalRandom;

public class VRPSolution extends AbstractGenericSolution<Double, DoubleProblem>
implements DoubleSolution{

	protected VRPSolution(DoubleProblem problem) {
		super(problem);
		initializeDoubleVariables();//随机初始化决策变量,赋值0或1
		
	}

	private void initializeDoubleVariables() {
		JMetalRandom jr = null;
		for (int i = 0 ; i < problem.getNumberOfVariables(); i++) {
		      Double value = jr.nextDouble(getLowerBound(i), getUpperBound(i));
		      setVariableValue(i, value);
		    }
	}

	@Override
	public String getVariableValueString(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Solution<Double> copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Object, Object> getAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getLowerBound(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getUpperBound(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	

}
