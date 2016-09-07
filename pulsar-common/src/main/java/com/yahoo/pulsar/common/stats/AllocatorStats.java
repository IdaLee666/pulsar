/**
 * Copyright 2016 Yahoo Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.yahoo.pulsar.common.stats;

import java.util.List;

public class AllocatorStats {
    public int numDirectArenas;
    public int numHeapArenas;
    public int numThreadLocalCaches;
    public int normalCacheSize;
    public int smallCacheSize;
    public int tinyCacheSize;

    public List<PoolArenaStats> directArenas;
    public List<PoolArenaStats> heapArenas;

    public static class PoolArenaStats {
        public int numTinySubpages;
        public int numSmallSubpages;
        public int numChunkLists;

        public List<PoolSubpageStats> tinySubpages;
        public List<PoolSubpageStats> smallSubpages;
        public List<PoolChunkListStats> chunkLists;
        public long numAllocations;
        public long numTinyAllocations;
        public long numSmallAllocations;
        public long numNormalAllocations;
        public long numHugeAllocations;
        public long numDeallocations;
        public long numTinyDeallocations;
        public long numSmallDeallocations;
        public long numNormalDeallocations;
        public long numHugeDeallocations;
        public long numActiveAllocations;
        public long numActiveTinyAllocations;
        public long numActiveSmallAllocations;
        public long numActiveNormalAllocations;
        public long numActiveHugeAllocations;
    }

    public static class PoolSubpageStats {
        public int maxNumElements;
        public int numAvailable;
        public int elementSize;
        public int pageSize;
    }

    public static class PoolChunkListStats {
        public int minUsage;
        public int maxUsage;
        public List<PoolChunkStats> chunks;
    }

    public static class PoolChunkStats {
        public int usage;
        public int chunkSize;
        public int freeBytes;
    }
}
