/*
 * Copyright 2017 Long Term Software LLC
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ltsllc.miranda.topics.states;

import com.ltsllc.miranda.State;
import com.ltsllc.miranda.file.states.SingleFileStartingState;
import com.ltsllc.miranda.topics.TopicsFile;

/**
 * Created by Clark on 5/18/2017.
 */
public class TopicsFileStartingState extends SingleFileStartingState {
    public TopicsFile getTopicsFile () {
        return (TopicsFile) getContainer();
    }

    public TopicsFileStartingState (TopicsFile topicsFile) {
        super(topicsFile);
    }

    public State getReadyState () {
        return new TopicsFileReadyState(getTopicsFile());
    }
}
