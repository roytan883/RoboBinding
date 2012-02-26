/**
 * Copyright 2012 Cheng Wei, Robert Taylor
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 */
package org.robobinding.viewattribute.adapterview;

import java.util.List;

import org.junit.Test;
import org.robobinding.viewattribute.AbstractGroupedViewAttributeTest;

import android.view.View;
import android.widget.ListView;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Robert Taylor
 */
public class AdaptedDataSetAttributesTest extends AbstractGroupedViewAttributeTest<AdaptedDataSetAttributes>
{
	private final Attribute source = attribute("source={source_property}");
	private final Attribute itemLayout = attribute("itemLayout=@layout/itemLayout");
	private final Attribute itemMapping = attribute("itemMapping=[text1.title:{title}]");

	@Test
	public void givenSourceAndItemLayoutAttributes_thenCreateInstancesOfBothAttributes()
	{
		givenAttributes(source, itemLayout);

		performInitialization();

		assertThatAttributesWereCreated(SourceAttribute.class, ItemLayoutAttribute.class);
	}

	@Test
	public void givenASourceItemLayoutAndItemMappingAttribute_thenCreateInstancesOfAllAttributes()
	{
		givenAttributes(source, itemLayout, itemMapping);

		performInitialization();

		assertThatAttributesWereCreated(SourceAttribute.class, ItemLayoutAttribute.class, ItemMappingAttribute.class);
	}

	@Test (expected=RuntimeException.class)
	public void givenASourceAttributeOnly_thenReject()
	{
		givenAttributes(source);

		performInitialization();
	}
	
	@Test (expected=RuntimeException.class)
	public void givenAnItemLayoutAttributeOnly_thenReject()
	{
		givenAttributes(itemLayout);

		performInitialization();
	}
	
	@Override
	protected List<?> getGeneratedChildAttributes(AdaptedDataSetAttributes adaptedDataSetAttributes)
	{
		return adaptedDataSetAttributes.childViewAttributes;
	}

	@Override
	protected Class<? extends View> overrideViewClass()
	{
		return ListView.class;
	}
}