package com.springboot.backed.apirest.auth;

public class JwtConfig {

	public static final String SECRET_KEY = "secret.key.123456789";
	
	public static final String RSA_PRIVATE = "-----BEGIN RSA PRIVATE KEY-----\n" + 
			"MIIEpAIBAAKCAQEA6RT6ZxAPjxrNLm2KoWWE//W0cfwRc6Hx3QHq1a0UZdnZtLZV\n" + 
			"A96EBA6mU2n0S/qZOGlhLlxb8OjkBm6HEOwuyLHbQkojtzLsUV3LfQdDEyMSVpsB\n" + 
			"vfE09On0XHvbWCH+o0b7Xfkisg/CW0Tl68BYZvQJEi6u02UFW5ECatyoVs5Kuotj\n" + 
			"OLeMEARSB/iPMitUnP/LFQ+qMmT0ZvbYhGfNQZKi8A+Dm+RdMZBh+Imj0+Uyen+w\n" + 
			"alc+UtV8alDXWfHxSpEzBkG5M+LcRfpqdHcErKdky9FsB8tq4eAkm4vaBmWjySWf\n" + 
			"I2mCtIw7yleWX9fBGkG1vyQUWV+7L5Ic7w2v7QIDAQABAoIBADjs3LMrIwGqZA5A\n" + 
			"xqjgaHkzAx0LmR+Kn82AWGBTYzX03Mzb8yt8vvVWtpyMthOQYrd6VTfDatkNqBNC\n" + 
			"D068wDhX59rqzIpDr5+3rqkciu8zk5j/Ro+jR3HBaeLkhQ+jTdOG1IGBBU5Dtw4f\n" + 
			"Z6AKXAzY8RY1vJD4jTRt2A9NUPfR9vBuSKSwMrHZ7IGyRYY1SUWUrZJSUMjypHNT\n" + 
			"LWM/O/L5r/QIVERZ9hzaA4IiLne9aIjI9Co0JPZPjZc4O3yG7IUqBOOnpWlZz6wI\n" + 
			"EGv6lKtGluKcbJSGhrQw5p2cfAlPOR7qj612SsoegYjae3gmAqB7z0fQrLZkRdPl\n" + 
			"fYFBPEECgYEA9Yjo0pNK+jlDPvCkLjOYum9OChjeOL+UlD4FYDNdswSAuKC8KBrk\n" + 
			"iJSMAQQSekHk/zLhopqzLtvx7DeYcKJkluxQ4Mfsk6U28tfPCaUpff0n+jl71GdM\n" + 
			"9z3ik+XxjQOZYbOUHQMY8GWgWGAZdwbrW0UI4iHPeU5ml9drCPcCqPkCgYEA8wQx\n" + 
			"R0AKaIqlFFAQWlVPqOENSPttXvihAtHIKX3H3kH4T11Mw1uqakWwFacfmgJomtJj\n" + 
			"uYESyMN98F+qkjVi649wr6+HkyHcW3hYibjEakhQ95ZoagdhtPLY5OTEd3ZZs8Rz\n" + 
			"r5zgYrQcWw9131RLIkQuby2hDGxcZLFxK/rgz5UCgYEAk/MVZ519dl1+2bQjGfvZ\n" + 
			"Ma3T9l2ZudQm8VSV5KvO8AnsjlO8TOY3gt0Pp6UOhUCjfero7xQMmFXL5qxxXJ1d\n" + 
			"w1tOOMP/F9Bb1eSYSpWM9O/QYQS2Svyb8fcGSlwqOvBKQgb1Xq35HxH9loMBlSlE\n" + 
			"NFDa03fQDqZhR2l0g4hjv/ECgYEAgIpiKmbUWpGjWcgzriRb218W8NiU9FwchmpC\n" + 
			"LrgqRQSt/ATEury8ujOcPQfGLmdBv0qzlwaP0gOdlMx1Y5q7dQ/NMhBtbMTHUtao\n" + 
			"Nki2E+Wmdh9noVXAN78QPJpI1UuTjQPHkUcwZOUR7pSR64whpcFcsk/3VKPohxZY\n" + 
			"X0P3L7UCgYBsUBE77pmSN79xGFlFw4FbeqlpQSX5c2RUu5gKHGcwgpxy1zOXmeyp\n" + 
			"dtmcFvCcER9QOJ189iNZ9abI90Jl7fxAgWmBlxBZwGyw9hJZe+sTdhwvu77QXmWf\n" + 
			"+hLrLIizyYPt7uC5SLiNX4jdZNmk/K3HOCPaZ+IQ8vaOr+5+bZeQJg==\n" + 
			"-----END RSA PRIVATE KEY-----";
	
	public static final String RSA_PUBLIC = "-----BEGIN PUBLIC KEY-----\n" + 
			"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA6RT6ZxAPjxrNLm2KoWWE\n" + 
			"//W0cfwRc6Hx3QHq1a0UZdnZtLZVA96EBA6mU2n0S/qZOGlhLlxb8OjkBm6HEOwu\n" + 
			"yLHbQkojtzLsUV3LfQdDEyMSVpsBvfE09On0XHvbWCH+o0b7Xfkisg/CW0Tl68BY\n" + 
			"ZvQJEi6u02UFW5ECatyoVs5KuotjOLeMEARSB/iPMitUnP/LFQ+qMmT0ZvbYhGfN\n" + 
			"QZKi8A+Dm+RdMZBh+Imj0+Uyen+walc+UtV8alDXWfHxSpEzBkG5M+LcRfpqdHcE\n" + 
			"rKdky9FsB8tq4eAkm4vaBmWjySWfI2mCtIw7yleWX9fBGkG1vyQUWV+7L5Ic7w2v\n" + 
			"7QIDAQAB\n" + 
			"-----END PUBLIC KEY-----";
	
}
