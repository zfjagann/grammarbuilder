package com.zealjagannatha.parsebuilder.grammar;

//Copyright 2012 Zeal Jagannatha
//
//Licensed under the Apache License, Version 2.0 (the "License");
//you may not use this file except in compliance with the License.
//You may obtain a copy of the License at
//
//  http://www.apache.org/licenses/LICENSE-2.0
//
//Unless required by applicable law or agreed to in writing, software
//distributed under the License is distributed on an "AS IS" BASIS,
//WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//See the License for the specific language governing permissions and
//limitations under the License.

public class ListSymbol implements Symbol {
	
	private Symbol internalType;
	private Literal delimiter;
	
	public ListSymbol(Symbol internalType, Literal delimiter) {
		this.internalType = internalType;
		this.delimiter = delimiter;
	}
	
	@Override
	public String toString() {
		return String.format("List<%s,%s>",internalType,delimiter);
	}

	public Symbol getType() {
		return internalType;
	}
	
	public Literal getDelimiter() {
		return delimiter;
	}

}
