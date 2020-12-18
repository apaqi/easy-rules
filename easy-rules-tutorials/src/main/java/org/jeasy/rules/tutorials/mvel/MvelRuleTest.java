/*
 * The MIT License
 *
 *  Copyright (c) 2020, Mahmoud Ben Hassine (mahmoud.benhassine@icloud.com)
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 */
package org.jeasy.rules.tutorials.mvel;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.api.RulesEngineParameters;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.mvel.MVELRuleFactory;
import org.jeasy.rules.support.reader.YamlRuleDefinitionReader;
import org.mvel2.ParserContext;
import org.testng.annotations.Test;

import java.io.FileReader;

public class MvelRuleTest {

    @Test
    public void test() throws Exception {
        // create a rules engine
        RulesEngineParameters parameters = new RulesEngineParameters().skipOnFirstAppliedRule(true);
        RulesEngine fizzBuzzEngine = new DefaultRulesEngine(parameters);

        // create rules
        String root = System.getProperty("user.dir");
        MVELRuleFactory mvelRuleFactory = new MVELRuleFactory(new YamlRuleDefinitionReader());
        Rules rules = mvelRuleFactory.createRules(new FileReader(root + "/src/main/resources/fizzbuzz.txt"));

        // fire rules
        Facts facts = new Facts();
        for (int i = 1; i <= 10; i++) {
            facts.put("number", i);
            fizzBuzzEngine.fire(rules, facts);
            System.out.println();
        }
    }

    @Test
    public void test_UnitRuleGroupFile() throws Exception {
        // create a rules engine
        RulesEngineParameters parameters = new RulesEngineParameters().skipOnFirstAppliedRule(true);
        RulesEngine fizzBuzzEngine = new DefaultRulesEngine(parameters);
        // create rules
        String root = System.getProperty("user.dir");
        MVELRuleFactory ruleFactory = new MVELRuleFactory(new YamlRuleDefinitionReader());
        Rules rules = ruleFactory.createRules(new FileReader(root + "/src/main/resources/unitRuleGroupFile.txt"));
        User user = new User() {{
            setAge(10);
            setName("wpx");
        }};
        // fire rules
        Facts facts = new Facts();
        facts.put("user", user);
        fizzBuzzEngine.fire(rules, facts);
        System.out.println();
    }

    @Test
    public void test_ActivationRuleGroupFile() throws Exception {
        //create a rules engine
        RulesEngineParameters parameters = new RulesEngineParameters().skipOnFirstAppliedRule(true);
        RulesEngine fizzBuzzEngine = new DefaultRulesEngine(parameters);
        // create rules
        String root = System.getProperty("user.dir");
        MVELRuleFactory ruleFactory = new MVELRuleFactory(new YamlRuleDefinitionReader());
        Rules rules = ruleFactory.createRules(new FileReader(root + "/src/main/resources/activationRuleGroupFile.txt"));
        User user = new User() {{
            setAge(30);
            setName("wpx");
        }};

        // fire rules
        Facts facts = new Facts();
        facts.put("user", user);
        fizzBuzzEngine.fire(rules, facts);
        System.out.println();
    }


}
