-- local key=KEYS[1]
--
-- local list=redis.call("lrange",key,0,-1);
--
-- return list;

--if redis.call('setnx',KEYS[1],ARGV[1]) == 1 then
--    return redis.call('expire',KEYS[1],ARGV[2])
--else
--    return -1000
--end


local count=redis.call("get",KEYS[1])
if count
then
    redis.call("incr",KEYS[1])
else
    redis.call("set",KEYS[1],1)
end
return count