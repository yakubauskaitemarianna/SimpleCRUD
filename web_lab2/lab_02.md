# 1.

## HTML PAGE 

### ab -n 1000 -c 5 http://localhost:8080/info


```
Server Software:
Server Hostname:        localhost
Server Port:            8080

Document Path:          /info
Document Length:        167 bytes

Concurrency Level:      5
Time taken for tests:   1.039 seconds
Complete requests:      1000
Failed requests:        0
Total transferred:      304000 bytes
HTML transferred:       167000 bytes
Requests per second:    962.76 [#/sec] (mean)
Time per request:       5.193 [ms] (mean)
Time per request:       1.039 [ms] (mean, across all concurrent requests)
```

## API

### ab -n 1000 -c 5 http://localhost:8080/employees


```
Server Software:
Server Hostname:        localhost
Server Port:            8080

Document Path:          /employees
Document Length:        165 bytes

Concurrency Level:      5
Time taken for tests:   0.949 seconds
Complete requests:      1000
Failed requests:        0
Total transferred:      270000 bytes
HTML transferred:       165000 bytes
Requests per second:    1053.64 [#/sec] (mean)
Time per request:       4.745 [ms] (mean)
Time per request:       0.949 [ms] (mean, across all concurrent requests)
Transfer rate:          277.82 [Kbytes/sec] received
```

## IMAGE

### ab -n 1000 -c 5 http://localhost:8080/image

```
Server Software:
Server Hostname:        localhost
Server Port:            8080

Document Path:          /image
Document Length:        152089 bytes

Concurrency Level:      5
Time taken for tests:   1.348 seconds
Complete requests:      1000
Failed requests:        0
Total transferred:      152212000 bytes
HTML transferred:       152089000 bytes
Requests per second:    741.68 [#/sec] (mean)
Time per request:       6.741 [ms] (mean)
Time per request:       1.348 [ms] (mean, across all concurrent requests)
Transfer rate:          110247.28 [Kbytes/sec] received
```

# 2. NGNIX

## HTML PAGE

### ab -n 1000 -c 5 http://localhost:53000/info

```
Server Software:        nginx/1.16.1
Server Hostname:        localhost
Server Port:            53000

Document Path:          /info
Document Length:        167 bytes

Concurrency Level:      5
Time taken for tests:   1.438 seconds
Complete requests:      1000
Failed requests:        0
Total transferred:      326000 bytes
HTML transferred:       167000 bytes
Requests per second:    695.31 [#/sec] (mean)
Time per request:       7.191 [ms] (mean)
Time per request:       1.438 [ms] (mean, across all concurrent requests)
Transfer rate:          221.36 [Kbytes/sec] received
```


## API

### ab -n 500 -c 5 http://localhost:53000/employees

```
Server Software:        nginx/1.16.1
Server Hostname:        localhost
Server Port:            53000

Document Path:          /employees
Document Length:        165 bytes

Concurrency Level:      5
Time taken for tests:   0.762 seconds
Complete requests:      500
Failed requests:        0
Total transferred:      146000 bytes
HTML transferred:       82500 bytes
Requests per second:    656.26 [#/sec] (mean)
Time per request:       7.619 [ms] (mean)
Time per request:       1.524 [ms] (mean, across all concurrent requests)
Transfer rate:          187.14 [Kbytes/sec] received
```


## IMAGE

### ab -n 1000 -c 5 http://localhost:53000/image

```
Server Software:        nginx/1.16.1
Server Hostname:        localhost
Server Port:            53000

Document Path:          /image
Document Length:        152089 bytes

Concurrency Level:      5
Time taken for tests:   27.043 seconds
Complete requests:      1000
Failed requests:        0
Total transferred:      152234000 bytes
HTML transferred:       152089000 bytes
Requests per second:    36.98 [#/sec] (mean)
Time per request:       135.216 [ms] (mean)
Time per request:       27.043 [ms] (mean, across all concurrent requests)
Transfer rate:          5497.36 [Kbytes/sec] received
```


# 3. GZIP & Cashing

## HTML PAGE

### ab -n 1000 -c 5 http://localhost:53000/info

```
Server Software:        nginx/1.16.1
Server Hostname:        localhost
Server Port:            53000

Document Path:          /info
Document Length:        167 bytes

Concurrency Level:      5
Time taken for tests:   0.668 seconds
Complete requests:      1000
Failed requests:        0
Total transferred:      326000 bytes
HTML transferred:       167000 bytes
Requests per second:    1497.96 [#/sec] (mean)
Time per request:       3.338 [ms] (mean)
Time per request:       0.668 [ms] (mean, across all concurrent requests)
Transfer rate:          476.89 [Kbytes/sec] received
```


## API

### ab -n 1000 -c 5 http://localhost:53000/employees

```
Server Software:        nginx/1.16.1
Server Hostname:        localhost
Server Port:            53000

Document Path:          /employees
Document Length:        165 bytes

Concurrency Level:      5
Time taken for tests:   0.618 seconds
Complete requests:      1000
Failed requests:        0
Total transferred:      292000 bytes
HTML transferred:       165000 bytes
Requests per second:    1618.45 [#/sec] (mean)
Time per request:       3.089 [ms] (mean)
Time per request:       0.618 [ms] (mean, across all concurrent requests)
Transfer rate:          461.51 [Kbytes/sec] received
```


## IMAGE

### ab -n 1000 -c 5 http://localhost:53000/image

```
Server Software:        nginx/1.16.1
Server Hostname:        localhost
Server Port:            53000

Document Path:          /image
Document Length:        152089 bytes

Concurrency Level:      5
Time taken for tests:   0.827 seconds
Complete requests:      1000
Failed requests:        0
Total transferred:      152234000 bytes
HTML transferred:       152089000 bytes
Requests per second:    1208.50 [#/sec] (mean)
Time per request:       4.137 [ms] (mean)
Time per request:       0.827 [ms] (mean, across all concurrent requests)
Transfer rate:          179663.55 [Kbytes/sec] received
```