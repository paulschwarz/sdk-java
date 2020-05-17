/*
 * Copyright 2018-Present The CloudEvents Authors
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package io.cloudevents.extensions;

import io.cloudevents.CloudEvent;
import io.cloudevents.Extension;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class DatarefExtension implements Extension {

    public static final String DATAREF = "dataref";

    private String dataref;

    public String getDataref() {
        return dataref;
    }

    public void setDataref(String dataref) {
        this.dataref = dataref;
    }

    @Override
    public void readFromEvent(CloudEvent event) {
        Object value = event.getExtensions().get(DATAREF);
        if (value != null) {
            this.dataref = value.toString();
        }
    }

    @Override
    public Map<String, Object> asMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put(DATAREF, this.dataref);
        return Collections.unmodifiableMap(map);
    }

    @Override
    public String toString() {
        return "DatarefExtension{" +
            "dataref='" + dataref + '\'' +
            '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dataref == null) ? 0
            : dataref.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DatarefExtension other = (DatarefExtension) obj;
        if (dataref == null) {
            return other.dataref == null;
        } else
            return dataref.equals(other.dataref);
    }
}
