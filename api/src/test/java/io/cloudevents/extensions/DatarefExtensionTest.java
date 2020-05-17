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

import static org.assertj.core.api.Assertions.assertThat;

import io.cloudevents.CloudEvent;
import org.junit.jupiter.api.Test;

/**
 * @author paulschwarz
 */
public class DatarefExtensionTest {

    @Test
    public void writeExtension() {
        DatarefExtension datarefExtension = new DatarefExtension();
        datarefExtension.setDataref("example dataref");

        CloudEvent event = CloudEvent.buildV1()
            .withExtension(datarefExtension)
            .build();

        assertThat(event.getExtensions())
            .containsEntry(DatarefExtension.DATAREF, "example dataref");
    }

    @Test
    public void parseExtension() {
        CloudEvent event = CloudEvent.buildV1()
            .withExtension(DatarefExtension.DATAREF, "example dataref")
            .build();

        DatarefExtension datarefExtension = ExtensionsParser.getInstance()
            .parseExtension(DatarefExtension.class, event);

        assertThat(datarefExtension).isNotNull();
        assertThat(datarefExtension.getDataref()).isEqualTo("example dataref");
    }
}
