/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package studio.raptor.ddal.common.algorithm.embed;


import java.util.List;
import studio.raptor.ddal.common.algorithm.HashRangeMultiKeyShardAlgorithm;

/**
 * 哈希和范围分片的默认实现方式
 *
 * @author Sam
 * @since 3.0.0
 */
public class DefaultHashRangeMultiKeyShardAlgorithm extends HashRangeMultiKeyShardAlgorithm<String> {

    public DefaultHashRangeMultiKeyShardAlgorithm(String fileName) {
        super(fileName);
    }

    @Override
    public int hashShardValue(Comparable shardValue) {
//        return hash(shardValue) % mod;
        return ((Long) (Long.parseLong(String.valueOf(shardValue)) % mod)).intValue();
    }

    @Override
    public int rangeShardValue(String shardValue, List<Range> ranges) {
        int i = 0;
        for (Range range : ranges) {
            if (range.inRange(Long.parseLong(String.valueOf(shardValue)))) {
                return i;
            }
            i++;
        }
        throw new RuntimeException("No range found for " + shardValue);
    }

//    private int hash(Object key) {
//        int h;
//        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
//    }
}
