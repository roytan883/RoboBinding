package org.robobinding.function;

import java.text.MessageFormat;
import java.util.List;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * @since 1.0
 * @author Cheng Wei
 *
 */
public class MethodDescription {
	private final String targetTypeName;
	private final String name;
	private final String returnTypeName;
	private final Class<?>[] parameterTypes;
	
	public MethodDescription(Class<?> targetType, String name, Class<?> returnType, Class<?>[] parameterTypes) {
		this(targetType.getName(), name, returnType.getName(), parameterTypes);
	}
	
	public MethodDescription(String targetTypeName, String name, String returnTypeName, Class<?>[] parameterTypes) {
		this.targetTypeName = targetTypeName;
		this.name = name;
		this.returnTypeName = returnTypeName;
		this.parameterTypes = parameterTypes;
	}
	
	@Override
	public String toString() {
		List<String> parameterTypesInString = getParameterTypesInString();

		return MessageFormat.format("{0} {1}.{2}({3})",
				returnTypeName,
				targetTypeName, 
				name, 
				Joiner.on(", ").join(parameterTypesInString));

	}

	private List<String> getParameterTypesInString() {
		List<String> parameterTypesInString = Lists.newArrayList();
		for (Class<?> parameterType : parameterTypes) {
			parameterTypesInString.add(parameterType.getName());
		}
		return parameterTypesInString;
	}
}
