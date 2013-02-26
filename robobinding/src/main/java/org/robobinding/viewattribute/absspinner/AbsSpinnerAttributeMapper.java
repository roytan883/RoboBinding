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
package org.robobinding.viewattribute.absspinner;

import static org.robobinding.viewattribute.absspinner.AdaptedAbsSpinnerDataSetAttributes.DROPDOWN_LAYOUT;
import static org.robobinding.viewattribute.absspinner.AdaptedAbsSpinnerDataSetAttributes.DROPDOWN_MAPPING;
import static org.robobinding.viewattribute.adapterview.AbstractAdaptedDataSetAttributes.ITEM_LAYOUT;
import static org.robobinding.viewattribute.adapterview.AbstractAdaptedDataSetAttributes.ITEM_MAPPING;
import static org.robobinding.viewattribute.adapterview.AbstractAdaptedDataSetAttributes.SOURCE;

import org.robobinding.viewattribute.BindingAttributeMapper;
import org.robobinding.viewattribute.BindingAttributeMappings;

import android.widget.AbsSpinner;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Robert Taylor
 */
public class AbsSpinnerAttributeMapper implements BindingAttributeMapper<AbsSpinner>
{
	@Override
	public void mapBindingAttributes(BindingAttributeMappings<AbsSpinner> mappings)
	{
		mappings.mapGroupedAttribute(AdaptedAbsSpinnerDataSetAttributes.class, SOURCE, 
				ITEM_LAYOUT, ITEM_MAPPING, 
				DROPDOWN_LAYOUT, DROPDOWN_MAPPING);
	}
}
