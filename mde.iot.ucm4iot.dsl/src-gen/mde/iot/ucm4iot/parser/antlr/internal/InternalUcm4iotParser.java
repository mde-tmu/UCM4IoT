package mde.iot.ucm4iot.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import mde.iot.ucm4iot.services.Ucm4iotGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalUcm4iotParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_IGNORE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'!'", "':'", "'on'", "'off'", "','", "'for'", "'('", "'-'", "')'", "'.'", "'['", "']'", "'{'", "'::'", "'}'", "'HUMAN'", "'SOFTWARE'", "'SENSOR'", "'ACTUATOR'", "'TAG'", "'READER'", "'PHYSICAL_ENTITY'", "'Standard'", "'standard'", "'Mode'", "'mode'", "'Use'", "'use'", "'Case'", "'case'", "'Handler'", "'handler'", "'Scope'", "'scope'", "'Intention'", "'intention'", "'Level'", "'level'", "'Multiplicity'", "'multiplicity'", "'Precondition'", "'precondition'", "'Postcondition'", "'postcondition'", "'Class'", "'class'", "'Contexts'", "'contexts'", "'And'", "'and'", "'Exceptions'", "'exceptions'", "'Main'", "'main'", "'Success'", "'success'", "'Scenario'", "'scenario'", "'Extensions'", "'extensions'", "'Alternative'", "'alternative'", "'Exception'", "'exception'", "'Nested'", "'nested'", "'Begin'", "'begin'", "'Ends'", "'ends'", "'Primary'", "'primary'", "'Actor'", "'actor'", "'Secondary'", "'secondary'", "'Facilitator'", "'facilitator'", "'ENVIRONMENT_EXCEPTION'", "'NETWORK_EXCEPTION'", "'HARDWARE_EXCEPTION'", "'SOFTWARE_EXCEPTION'", "'In'", "'in'", "'Continues'", "'continues'", "'At'", "'at'", "'Step'", "'step'", "'None'", "'none'", "'N/A'", "'n/a'", "'SUMMARY'", "'USER_GOAL'", "'SUB_FUNCTION'", "'SUCCESS'", "'FAILURE'", "'DEGRADED'", "'ABANDONED'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int RULE_INT=7;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__37=37;
    public static final int RULE_IGNORE_STRING=6;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__99=99;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__111=111;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int T__112=112;
    public static final int RULE_WS=10;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

    // delegates
    // delegators


        public InternalUcm4iotParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalUcm4iotParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalUcm4iotParser.tokenNames; }
    public String getGrammarFileName() { return "InternalUcm4iot.g"; }



     	private Ucm4iotGrammarAccess grammarAccess;

        public InternalUcm4iotParser(TokenStream input, Ucm4iotGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "IoTUseCaseModel";
       	}

       	@Override
       	protected Ucm4iotGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleIoTUseCaseModel"
    // InternalUcm4iot.g:65:1: entryRuleIoTUseCaseModel returns [EObject current=null] : iv_ruleIoTUseCaseModel= ruleIoTUseCaseModel EOF ;
    public final EObject entryRuleIoTUseCaseModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIoTUseCaseModel = null;


        try {
            // InternalUcm4iot.g:65:56: (iv_ruleIoTUseCaseModel= ruleIoTUseCaseModel EOF )
            // InternalUcm4iot.g:66:2: iv_ruleIoTUseCaseModel= ruleIoTUseCaseModel EOF
            {
             newCompositeNode(grammarAccess.getIoTUseCaseModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIoTUseCaseModel=ruleIoTUseCaseModel();

            state._fsp--;

             current =iv_ruleIoTUseCaseModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIoTUseCaseModel"


    // $ANTLR start "ruleIoTUseCaseModel"
    // InternalUcm4iot.g:72:1: ruleIoTUseCaseModel returns [EObject current=null] : ( ( () otherlv_1= '!' ruleKeywordStandardMode otherlv_3= ':' ( ( (lv_standardMode_4_0= 'on' ) ) | otherlv_5= 'off' ) )? ( (lv_useCases_6_0= ruleUseCase ) )* ) ;
    public final EObject ruleIoTUseCaseModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_standardMode_4_0=null;
        Token otherlv_5=null;
        EObject lv_useCases_6_0 = null;



        	enterRule();

        try {
            // InternalUcm4iot.g:78:2: ( ( ( () otherlv_1= '!' ruleKeywordStandardMode otherlv_3= ':' ( ( (lv_standardMode_4_0= 'on' ) ) | otherlv_5= 'off' ) )? ( (lv_useCases_6_0= ruleUseCase ) )* ) )
            // InternalUcm4iot.g:79:2: ( ( () otherlv_1= '!' ruleKeywordStandardMode otherlv_3= ':' ( ( (lv_standardMode_4_0= 'on' ) ) | otherlv_5= 'off' ) )? ( (lv_useCases_6_0= ruleUseCase ) )* )
            {
            // InternalUcm4iot.g:79:2: ( ( () otherlv_1= '!' ruleKeywordStandardMode otherlv_3= ':' ( ( (lv_standardMode_4_0= 'on' ) ) | otherlv_5= 'off' ) )? ( (lv_useCases_6_0= ruleUseCase ) )* )
            // InternalUcm4iot.g:80:3: ( () otherlv_1= '!' ruleKeywordStandardMode otherlv_3= ':' ( ( (lv_standardMode_4_0= 'on' ) ) | otherlv_5= 'off' ) )? ( (lv_useCases_6_0= ruleUseCase ) )*
            {
            // InternalUcm4iot.g:80:3: ( () otherlv_1= '!' ruleKeywordStandardMode otherlv_3= ':' ( ( (lv_standardMode_4_0= 'on' ) ) | otherlv_5= 'off' ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalUcm4iot.g:81:4: () otherlv_1= '!' ruleKeywordStandardMode otherlv_3= ':' ( ( (lv_standardMode_4_0= 'on' ) ) | otherlv_5= 'off' )
                    {
                    // InternalUcm4iot.g:81:4: ()
                    // InternalUcm4iot.g:82:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getIoTUseCaseModelAccess().getIoTUseCaseModelAction_0_0(),
                    						current);
                    				

                    }

                    otherlv_1=(Token)match(input,12,FOLLOW_3); 

                    				newLeafNode(otherlv_1, grammarAccess.getIoTUseCaseModelAccess().getExclamationMarkKeyword_0_1());
                    			

                    				newCompositeNode(grammarAccess.getIoTUseCaseModelAccess().getKeywordStandardModeParserRuleCall_0_2());
                    			
                    pushFollow(FOLLOW_4);
                    ruleKeywordStandardMode();

                    state._fsp--;


                    				afterParserOrEnumRuleCall();
                    			
                    otherlv_3=(Token)match(input,13,FOLLOW_5); 

                    				newLeafNode(otherlv_3, grammarAccess.getIoTUseCaseModelAccess().getColonKeyword_0_3());
                    			
                    // InternalUcm4iot.g:103:4: ( ( (lv_standardMode_4_0= 'on' ) ) | otherlv_5= 'off' )
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==14) ) {
                        alt1=1;
                    }
                    else if ( (LA1_0==15) ) {
                        alt1=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 1, 0, input);

                        throw nvae;
                    }
                    switch (alt1) {
                        case 1 :
                            // InternalUcm4iot.g:104:5: ( (lv_standardMode_4_0= 'on' ) )
                            {
                            // InternalUcm4iot.g:104:5: ( (lv_standardMode_4_0= 'on' ) )
                            // InternalUcm4iot.g:105:6: (lv_standardMode_4_0= 'on' )
                            {
                            // InternalUcm4iot.g:105:6: (lv_standardMode_4_0= 'on' )
                            // InternalUcm4iot.g:106:7: lv_standardMode_4_0= 'on'
                            {
                            lv_standardMode_4_0=(Token)match(input,14,FOLLOW_6); 

                            							newLeafNode(lv_standardMode_4_0, grammarAccess.getIoTUseCaseModelAccess().getStandardModeOnKeyword_0_4_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getIoTUseCaseModelRule());
                            							}
                            							setWithLastConsumed(current, "standardMode", lv_standardMode_4_0 != null, "on");
                            						

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalUcm4iot.g:119:5: otherlv_5= 'off'
                            {
                            otherlv_5=(Token)match(input,15,FOLLOW_6); 

                            					newLeafNode(otherlv_5, grammarAccess.getIoTUseCaseModelAccess().getOffKeyword_0_4_1());
                            				

                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalUcm4iot.g:125:3: ( (lv_useCases_6_0= ruleUseCase ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=38 && LA3_0<=39)||(LA3_0>=42 && LA3_0<=43)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalUcm4iot.g:126:4: (lv_useCases_6_0= ruleUseCase )
            	    {
            	    // InternalUcm4iot.g:126:4: (lv_useCases_6_0= ruleUseCase )
            	    // InternalUcm4iot.g:127:5: lv_useCases_6_0= ruleUseCase
            	    {

            	    					newCompositeNode(grammarAccess.getIoTUseCaseModelAccess().getUseCasesUseCaseParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_6);
            	    lv_useCases_6_0=ruleUseCase();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getIoTUseCaseModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"useCases",
            	    						lv_useCases_6_0,
            	    						"mde.iot.ucm4iot.Ucm4iot.UseCase");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIoTUseCaseModel"


    // $ANTLR start "entryRuleUseCase"
    // InternalUcm4iot.g:148:1: entryRuleUseCase returns [EObject current=null] : iv_ruleUseCase= ruleUseCase EOF ;
    public final EObject entryRuleUseCase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUseCase = null;


        try {
            // InternalUcm4iot.g:148:48: (iv_ruleUseCase= ruleUseCase EOF )
            // InternalUcm4iot.g:149:2: iv_ruleUseCase= ruleUseCase EOF
            {
             newCompositeNode(grammarAccess.getUseCaseRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUseCase=ruleUseCase();

            state._fsp--;

             current =iv_ruleUseCase; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUseCase"


    // $ANTLR start "ruleUseCase"
    // InternalUcm4iot.g:155:1: ruleUseCase returns [EObject current=null] : ( (this_ExceptionalUseCase_0= ruleExceptionalUseCase | this_HandlerUseCase_1= ruleHandlerUseCase ) ruleKeywordMainSuccessScenario otherlv_3= ':' ( (lv_main_4_0= ruleMainScenario ) ) ( ruleKeywordExtensions otherlv_6= ':' ( (lv_extensions_7_0= ruleExtensions ) ) )? ) ;
    public final EObject ruleUseCase() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        Token otherlv_6=null;
        EObject this_ExceptionalUseCase_0 = null;

        EObject this_HandlerUseCase_1 = null;

        EObject lv_main_4_0 = null;

        EObject lv_extensions_7_0 = null;



        	enterRule();

        try {
            // InternalUcm4iot.g:161:2: ( ( (this_ExceptionalUseCase_0= ruleExceptionalUseCase | this_HandlerUseCase_1= ruleHandlerUseCase ) ruleKeywordMainSuccessScenario otherlv_3= ':' ( (lv_main_4_0= ruleMainScenario ) ) ( ruleKeywordExtensions otherlv_6= ':' ( (lv_extensions_7_0= ruleExtensions ) ) )? ) )
            // InternalUcm4iot.g:162:2: ( (this_ExceptionalUseCase_0= ruleExceptionalUseCase | this_HandlerUseCase_1= ruleHandlerUseCase ) ruleKeywordMainSuccessScenario otherlv_3= ':' ( (lv_main_4_0= ruleMainScenario ) ) ( ruleKeywordExtensions otherlv_6= ':' ( (lv_extensions_7_0= ruleExtensions ) ) )? )
            {
            // InternalUcm4iot.g:162:2: ( (this_ExceptionalUseCase_0= ruleExceptionalUseCase | this_HandlerUseCase_1= ruleHandlerUseCase ) ruleKeywordMainSuccessScenario otherlv_3= ':' ( (lv_main_4_0= ruleMainScenario ) ) ( ruleKeywordExtensions otherlv_6= ':' ( (lv_extensions_7_0= ruleExtensions ) ) )? )
            // InternalUcm4iot.g:163:3: (this_ExceptionalUseCase_0= ruleExceptionalUseCase | this_HandlerUseCase_1= ruleHandlerUseCase ) ruleKeywordMainSuccessScenario otherlv_3= ':' ( (lv_main_4_0= ruleMainScenario ) ) ( ruleKeywordExtensions otherlv_6= ':' ( (lv_extensions_7_0= ruleExtensions ) ) )?
            {
            // InternalUcm4iot.g:163:3: (this_ExceptionalUseCase_0= ruleExceptionalUseCase | this_HandlerUseCase_1= ruleHandlerUseCase )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=38 && LA4_0<=39)) ) {
                alt4=1;
            }
            else if ( ((LA4_0>=42 && LA4_0<=43)) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalUcm4iot.g:164:4: this_ExceptionalUseCase_0= ruleExceptionalUseCase
                    {

                    				newCompositeNode(grammarAccess.getUseCaseAccess().getExceptionalUseCaseParserRuleCall_0_0());
                    			
                    pushFollow(FOLLOW_7);
                    this_ExceptionalUseCase_0=ruleExceptionalUseCase();

                    state._fsp--;


                    				current = this_ExceptionalUseCase_0;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:173:4: this_HandlerUseCase_1= ruleHandlerUseCase
                    {

                    				newCompositeNode(grammarAccess.getUseCaseAccess().getHandlerUseCaseParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_7);
                    this_HandlerUseCase_1=ruleHandlerUseCase();

                    state._fsp--;


                    				current = this_HandlerUseCase_1;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }


            			newCompositeNode(grammarAccess.getUseCaseAccess().getKeywordMainSuccessScenarioParserRuleCall_1());
            		
            pushFollow(FOLLOW_4);
            ruleKeywordMainSuccessScenario();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		
            otherlv_3=(Token)match(input,13,FOLLOW_8); 

            			newLeafNode(otherlv_3, grammarAccess.getUseCaseAccess().getColonKeyword_2());
            		
            // InternalUcm4iot.g:193:3: ( (lv_main_4_0= ruleMainScenario ) )
            // InternalUcm4iot.g:194:4: (lv_main_4_0= ruleMainScenario )
            {
            // InternalUcm4iot.g:194:4: (lv_main_4_0= ruleMainScenario )
            // InternalUcm4iot.g:195:5: lv_main_4_0= ruleMainScenario
            {

            					newCompositeNode(grammarAccess.getUseCaseAccess().getMainMainScenarioParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_9);
            lv_main_4_0=ruleMainScenario();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUseCaseRule());
            					}
            					set(
            						current,
            						"main",
            						lv_main_4_0,
            						"mde.iot.ucm4iot.Ucm4iot.MainScenario");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalUcm4iot.g:212:3: ( ruleKeywordExtensions otherlv_6= ':' ( (lv_extensions_7_0= ruleExtensions ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=70 && LA5_0<=71)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalUcm4iot.g:213:4: ruleKeywordExtensions otherlv_6= ':' ( (lv_extensions_7_0= ruleExtensions ) )
                    {

                    				newCompositeNode(grammarAccess.getUseCaseAccess().getKeywordExtensionsParserRuleCall_4_0());
                    			
                    pushFollow(FOLLOW_4);
                    ruleKeywordExtensions();

                    state._fsp--;


                    				afterParserOrEnumRuleCall();
                    			
                    otherlv_6=(Token)match(input,13,FOLLOW_10); 

                    				newLeafNode(otherlv_6, grammarAccess.getUseCaseAccess().getColonKeyword_4_1());
                    			
                    // InternalUcm4iot.g:224:4: ( (lv_extensions_7_0= ruleExtensions ) )
                    // InternalUcm4iot.g:225:5: (lv_extensions_7_0= ruleExtensions )
                    {
                    // InternalUcm4iot.g:225:5: (lv_extensions_7_0= ruleExtensions )
                    // InternalUcm4iot.g:226:6: lv_extensions_7_0= ruleExtensions
                    {

                    						newCompositeNode(grammarAccess.getUseCaseAccess().getExtensionsExtensionsParserRuleCall_4_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_extensions_7_0=ruleExtensions();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getUseCaseRule());
                    						}
                    						set(
                    							current,
                    							"extensions",
                    							lv_extensions_7_0,
                    							"mde.iot.ucm4iot.Ucm4iot.Extensions");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUseCase"


    // $ANTLR start "entryRuleExceptionalUseCase"
    // InternalUcm4iot.g:248:1: entryRuleExceptionalUseCase returns [EObject current=null] : iv_ruleExceptionalUseCase= ruleExceptionalUseCase EOF ;
    public final EObject entryRuleExceptionalUseCase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExceptionalUseCase = null;


        try {
            // InternalUcm4iot.g:248:59: (iv_ruleExceptionalUseCase= ruleExceptionalUseCase EOF )
            // InternalUcm4iot.g:249:2: iv_ruleExceptionalUseCase= ruleExceptionalUseCase EOF
            {
             newCompositeNode(grammarAccess.getExceptionalUseCaseRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExceptionalUseCase=ruleExceptionalUseCase();

            state._fsp--;

             current =iv_ruleExceptionalUseCase; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExceptionalUseCase"


    // $ANTLR start "ruleExceptionalUseCase"
    // InternalUcm4iot.g:255:1: ruleExceptionalUseCase returns [EObject current=null] : ( ruleKeywordExceptionalUseCase otherlv_1= ':' ( (lv_name_2_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => ( ruleKeywordScope otherlv_5= ':' ( (lv_scope_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordIntention otherlv_8= ':' ( (lv_intent_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordLevel otherlv_11= ':' ( (lv_level_12_0= ruleLevel ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordMultiplicity otherlv_14= ':' ( (lv_multiplicity_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrecondition otherlv_17= ':' ( (lv_precondition_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPostcondition otherlv_20= ':' ( (lv_postcondition_21_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrimaryActor otherlv_23= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordSecondaryActor otherlv_28= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordFacilitatorActor otherlv_35= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) )+ {...}?) ) ) ) ;
    public final EObject ruleExceptionalUseCase() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_5=null;
        Token lv_scope_6_0=null;
        Token otherlv_8=null;
        Token lv_intent_9_0=null;
        Token otherlv_11=null;
        Token otherlv_14=null;
        Token lv_multiplicity_15_0=null;
        Token otherlv_17=null;
        Token lv_precondition_18_0=null;
        Token otherlv_20=null;
        Token lv_postcondition_21_0=null;
        Token otherlv_23=null;
        Token otherlv_28=null;
        Token otherlv_32=null;
        Token otherlv_35=null;
        Token otherlv_39=null;
        Enumerator lv_level_12_0 = null;

        EObject lv_primaryActor_26_0 = null;

        EObject lv_secondaryActors_31_0 = null;

        EObject lv_secondaryActors_33_0 = null;

        EObject lv_facilitatorActors_38_0 = null;

        EObject lv_facilitatorActors_40_0 = null;



        	enterRule();

        try {
            // InternalUcm4iot.g:261:2: ( ( ruleKeywordExceptionalUseCase otherlv_1= ':' ( (lv_name_2_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => ( ruleKeywordScope otherlv_5= ':' ( (lv_scope_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordIntention otherlv_8= ':' ( (lv_intent_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordLevel otherlv_11= ':' ( (lv_level_12_0= ruleLevel ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordMultiplicity otherlv_14= ':' ( (lv_multiplicity_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrecondition otherlv_17= ':' ( (lv_precondition_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPostcondition otherlv_20= ':' ( (lv_postcondition_21_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrimaryActor otherlv_23= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordSecondaryActor otherlv_28= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordFacilitatorActor otherlv_35= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) )+ {...}?) ) ) ) )
            // InternalUcm4iot.g:262:2: ( ruleKeywordExceptionalUseCase otherlv_1= ':' ( (lv_name_2_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => ( ruleKeywordScope otherlv_5= ':' ( (lv_scope_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordIntention otherlv_8= ':' ( (lv_intent_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordLevel otherlv_11= ':' ( (lv_level_12_0= ruleLevel ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordMultiplicity otherlv_14= ':' ( (lv_multiplicity_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrecondition otherlv_17= ':' ( (lv_precondition_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPostcondition otherlv_20= ':' ( (lv_postcondition_21_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrimaryActor otherlv_23= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordSecondaryActor otherlv_28= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordFacilitatorActor otherlv_35= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) )+ {...}?) ) ) )
            {
            // InternalUcm4iot.g:262:2: ( ruleKeywordExceptionalUseCase otherlv_1= ':' ( (lv_name_2_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => ( ruleKeywordScope otherlv_5= ':' ( (lv_scope_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordIntention otherlv_8= ':' ( (lv_intent_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordLevel otherlv_11= ':' ( (lv_level_12_0= ruleLevel ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordMultiplicity otherlv_14= ':' ( (lv_multiplicity_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrecondition otherlv_17= ':' ( (lv_precondition_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPostcondition otherlv_20= ':' ( (lv_postcondition_21_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrimaryActor otherlv_23= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordSecondaryActor otherlv_28= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordFacilitatorActor otherlv_35= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) )+ {...}?) ) ) )
            // InternalUcm4iot.g:263:3: ruleKeywordExceptionalUseCase otherlv_1= ':' ( (lv_name_2_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => ( ruleKeywordScope otherlv_5= ':' ( (lv_scope_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordIntention otherlv_8= ':' ( (lv_intent_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordLevel otherlv_11= ':' ( (lv_level_12_0= ruleLevel ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordMultiplicity otherlv_14= ':' ( (lv_multiplicity_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrecondition otherlv_17= ':' ( (lv_precondition_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPostcondition otherlv_20= ':' ( (lv_postcondition_21_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrimaryActor otherlv_23= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordSecondaryActor otherlv_28= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordFacilitatorActor otherlv_35= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) )+ {...}?) ) )
            {

            			newCompositeNode(grammarAccess.getExceptionalUseCaseAccess().getKeywordExceptionalUseCaseParserRuleCall_0());
            		
            pushFollow(FOLLOW_4);
            ruleKeywordExceptionalUseCase();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		
            otherlv_1=(Token)match(input,13,FOLLOW_11); 

            			newLeafNode(otherlv_1, grammarAccess.getExceptionalUseCaseAccess().getColonKeyword_1());
            		
            // InternalUcm4iot.g:274:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalUcm4iot.g:275:4: (lv_name_2_0= RULE_ID )
            {
            // InternalUcm4iot.g:275:4: (lv_name_2_0= RULE_ID )
            // InternalUcm4iot.g:276:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_12); 

            					newLeafNode(lv_name_2_0, grammarAccess.getExceptionalUseCaseAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getExceptionalUseCaseRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalUcm4iot.g:292:3: ( ( ( ( ({...}? => ( ({...}? => ( ruleKeywordScope otherlv_5= ':' ( (lv_scope_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordIntention otherlv_8= ':' ( (lv_intent_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordLevel otherlv_11= ':' ( (lv_level_12_0= ruleLevel ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordMultiplicity otherlv_14= ':' ( (lv_multiplicity_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrecondition otherlv_17= ':' ( (lv_precondition_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPostcondition otherlv_20= ':' ( (lv_postcondition_21_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrimaryActor otherlv_23= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordSecondaryActor otherlv_28= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordFacilitatorActor otherlv_35= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) )+ {...}?) ) )
            // InternalUcm4iot.g:293:4: ( ( ( ({...}? => ( ({...}? => ( ruleKeywordScope otherlv_5= ':' ( (lv_scope_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordIntention otherlv_8= ':' ( (lv_intent_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordLevel otherlv_11= ':' ( (lv_level_12_0= ruleLevel ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordMultiplicity otherlv_14= ':' ( (lv_multiplicity_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrecondition otherlv_17= ':' ( (lv_precondition_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPostcondition otherlv_20= ':' ( (lv_postcondition_21_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrimaryActor otherlv_23= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordSecondaryActor otherlv_28= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordFacilitatorActor otherlv_35= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) )+ {...}?) )
            {
            // InternalUcm4iot.g:293:4: ( ( ( ({...}? => ( ({...}? => ( ruleKeywordScope otherlv_5= ':' ( (lv_scope_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordIntention otherlv_8= ':' ( (lv_intent_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordLevel otherlv_11= ':' ( (lv_level_12_0= ruleLevel ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordMultiplicity otherlv_14= ':' ( (lv_multiplicity_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrecondition otherlv_17= ':' ( (lv_precondition_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPostcondition otherlv_20= ':' ( (lv_postcondition_21_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrimaryActor otherlv_23= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordSecondaryActor otherlv_28= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordFacilitatorActor otherlv_35= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) )+ {...}?) )
            // InternalUcm4iot.g:294:5: ( ( ({...}? => ( ({...}? => ( ruleKeywordScope otherlv_5= ':' ( (lv_scope_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordIntention otherlv_8= ':' ( (lv_intent_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordLevel otherlv_11= ':' ( (lv_level_12_0= ruleLevel ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordMultiplicity otherlv_14= ':' ( (lv_multiplicity_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrecondition otherlv_17= ':' ( (lv_precondition_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPostcondition otherlv_20= ':' ( (lv_postcondition_21_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrimaryActor otherlv_23= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordSecondaryActor otherlv_28= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordFacilitatorActor otherlv_35= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) )+ {...}?)
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3());
            				
            // InternalUcm4iot.g:297:5: ( ( ({...}? => ( ({...}? => ( ruleKeywordScope otherlv_5= ':' ( (lv_scope_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordIntention otherlv_8= ':' ( (lv_intent_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordLevel otherlv_11= ':' ( (lv_level_12_0= ruleLevel ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordMultiplicity otherlv_14= ':' ( (lv_multiplicity_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrecondition otherlv_17= ':' ( (lv_precondition_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPostcondition otherlv_20= ':' ( (lv_postcondition_21_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrimaryActor otherlv_23= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordSecondaryActor otherlv_28= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordFacilitatorActor otherlv_35= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) )+ {...}?)
            // InternalUcm4iot.g:298:6: ( ({...}? => ( ({...}? => ( ruleKeywordScope otherlv_5= ':' ( (lv_scope_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordIntention otherlv_8= ':' ( (lv_intent_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordLevel otherlv_11= ':' ( (lv_level_12_0= ruleLevel ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordMultiplicity otherlv_14= ':' ( (lv_multiplicity_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrecondition otherlv_17= ':' ( (lv_precondition_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPostcondition otherlv_20= ':' ( (lv_postcondition_21_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrimaryActor otherlv_23= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordSecondaryActor otherlv_28= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordFacilitatorActor otherlv_35= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) )+ {...}?
            {
            // InternalUcm4iot.g:298:6: ( ({...}? => ( ({...}? => ( ruleKeywordScope otherlv_5= ':' ( (lv_scope_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordIntention otherlv_8= ':' ( (lv_intent_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordLevel otherlv_11= ':' ( (lv_level_12_0= ruleLevel ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordMultiplicity otherlv_14= ':' ( (lv_multiplicity_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrecondition otherlv_17= ':' ( (lv_precondition_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPostcondition otherlv_20= ':' ( (lv_postcondition_21_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrimaryActor otherlv_23= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordSecondaryActor otherlv_28= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordFacilitatorActor otherlv_35= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) )+
            int cnt14=0;
            loop14:
            do {
                int alt14=10;
                alt14 = dfa14.predict(input);
                switch (alt14) {
            	case 1 :
            	    // InternalUcm4iot.g:299:4: ({...}? => ( ({...}? => ( ruleKeywordScope otherlv_5= ':' ( (lv_scope_6_0= RULE_ID ) ) ) ) ) )
            	    {
            	    // InternalUcm4iot.g:299:4: ({...}? => ( ({...}? => ( ruleKeywordScope otherlv_5= ':' ( (lv_scope_6_0= RULE_ID ) ) ) ) ) )
            	    // InternalUcm4iot.g:300:5: {...}? => ( ({...}? => ( ruleKeywordScope otherlv_5= ':' ( (lv_scope_6_0= RULE_ID ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleExceptionalUseCase", "getUnorderedGroupHelper().canSelect(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // InternalUcm4iot.g:300:115: ( ({...}? => ( ruleKeywordScope otherlv_5= ':' ( (lv_scope_6_0= RULE_ID ) ) ) ) )
            	    // InternalUcm4iot.g:301:6: ({...}? => ( ruleKeywordScope otherlv_5= ':' ( (lv_scope_6_0= RULE_ID ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3(), 0);
            	    					
            	    // InternalUcm4iot.g:304:9: ({...}? => ( ruleKeywordScope otherlv_5= ':' ( (lv_scope_6_0= RULE_ID ) ) ) )
            	    // InternalUcm4iot.g:304:10: {...}? => ( ruleKeywordScope otherlv_5= ':' ( (lv_scope_6_0= RULE_ID ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleExceptionalUseCase", "true");
            	    }
            	    // InternalUcm4iot.g:304:19: ( ruleKeywordScope otherlv_5= ':' ( (lv_scope_6_0= RULE_ID ) ) )
            	    // InternalUcm4iot.g:304:20: ruleKeywordScope otherlv_5= ':' ( (lv_scope_6_0= RULE_ID ) )
            	    {

            	    									newCompositeNode(grammarAccess.getExceptionalUseCaseAccess().getKeywordScopeParserRuleCall_3_0_0());
            	    								
            	    pushFollow(FOLLOW_4);
            	    ruleKeywordScope();

            	    state._fsp--;


            	    									afterParserOrEnumRuleCall();
            	    								
            	    otherlv_5=(Token)match(input,13,FOLLOW_11); 

            	    									newLeafNode(otherlv_5, grammarAccess.getExceptionalUseCaseAccess().getColonKeyword_3_0_1());
            	    								
            	    // InternalUcm4iot.g:315:9: ( (lv_scope_6_0= RULE_ID ) )
            	    // InternalUcm4iot.g:316:10: (lv_scope_6_0= RULE_ID )
            	    {
            	    // InternalUcm4iot.g:316:10: (lv_scope_6_0= RULE_ID )
            	    // InternalUcm4iot.g:317:11: lv_scope_6_0= RULE_ID
            	    {
            	    lv_scope_6_0=(Token)match(input,RULE_ID,FOLLOW_13); 

            	    											newLeafNode(lv_scope_6_0, grammarAccess.getExceptionalUseCaseAccess().getScopeIDTerminalRuleCall_3_0_2_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getExceptionalUseCaseRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"scope",
            	    												lv_scope_6_0,
            	    												"org.eclipse.xtext.common.Terminals.ID");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalUcm4iot.g:339:4: ({...}? => ( ({...}? => ( ruleKeywordIntention otherlv_8= ':' ( (lv_intent_9_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalUcm4iot.g:339:4: ({...}? => ( ({...}? => ( ruleKeywordIntention otherlv_8= ':' ( (lv_intent_9_0= RULE_STRING ) ) ) ) ) )
            	    // InternalUcm4iot.g:340:5: {...}? => ( ({...}? => ( ruleKeywordIntention otherlv_8= ':' ( (lv_intent_9_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleExceptionalUseCase", "getUnorderedGroupHelper().canSelect(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // InternalUcm4iot.g:340:115: ( ({...}? => ( ruleKeywordIntention otherlv_8= ':' ( (lv_intent_9_0= RULE_STRING ) ) ) ) )
            	    // InternalUcm4iot.g:341:6: ({...}? => ( ruleKeywordIntention otherlv_8= ':' ( (lv_intent_9_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3(), 1);
            	    					
            	    // InternalUcm4iot.g:344:9: ({...}? => ( ruleKeywordIntention otherlv_8= ':' ( (lv_intent_9_0= RULE_STRING ) ) ) )
            	    // InternalUcm4iot.g:344:10: {...}? => ( ruleKeywordIntention otherlv_8= ':' ( (lv_intent_9_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleExceptionalUseCase", "true");
            	    }
            	    // InternalUcm4iot.g:344:19: ( ruleKeywordIntention otherlv_8= ':' ( (lv_intent_9_0= RULE_STRING ) ) )
            	    // InternalUcm4iot.g:344:20: ruleKeywordIntention otherlv_8= ':' ( (lv_intent_9_0= RULE_STRING ) )
            	    {

            	    									newCompositeNode(grammarAccess.getExceptionalUseCaseAccess().getKeywordIntentionParserRuleCall_3_1_0());
            	    								
            	    pushFollow(FOLLOW_4);
            	    ruleKeywordIntention();

            	    state._fsp--;


            	    									afterParserOrEnumRuleCall();
            	    								
            	    otherlv_8=(Token)match(input,13,FOLLOW_14); 

            	    									newLeafNode(otherlv_8, grammarAccess.getExceptionalUseCaseAccess().getColonKeyword_3_1_1());
            	    								
            	    // InternalUcm4iot.g:355:9: ( (lv_intent_9_0= RULE_STRING ) )
            	    // InternalUcm4iot.g:356:10: (lv_intent_9_0= RULE_STRING )
            	    {
            	    // InternalUcm4iot.g:356:10: (lv_intent_9_0= RULE_STRING )
            	    // InternalUcm4iot.g:357:11: lv_intent_9_0= RULE_STRING
            	    {
            	    lv_intent_9_0=(Token)match(input,RULE_STRING,FOLLOW_13); 

            	    											newLeafNode(lv_intent_9_0, grammarAccess.getExceptionalUseCaseAccess().getIntentSTRINGTerminalRuleCall_3_1_2_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getExceptionalUseCaseRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"intent",
            	    												lv_intent_9_0,
            	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalUcm4iot.g:379:4: ({...}? => ( ({...}? => ( ruleKeywordLevel otherlv_11= ':' ( (lv_level_12_0= ruleLevel ) ) ) ) ) )
            	    {
            	    // InternalUcm4iot.g:379:4: ({...}? => ( ({...}? => ( ruleKeywordLevel otherlv_11= ':' ( (lv_level_12_0= ruleLevel ) ) ) ) ) )
            	    // InternalUcm4iot.g:380:5: {...}? => ( ({...}? => ( ruleKeywordLevel otherlv_11= ':' ( (lv_level_12_0= ruleLevel ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleExceptionalUseCase", "getUnorderedGroupHelper().canSelect(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // InternalUcm4iot.g:380:115: ( ({...}? => ( ruleKeywordLevel otherlv_11= ':' ( (lv_level_12_0= ruleLevel ) ) ) ) )
            	    // InternalUcm4iot.g:381:6: ({...}? => ( ruleKeywordLevel otherlv_11= ':' ( (lv_level_12_0= ruleLevel ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3(), 2);
            	    					
            	    // InternalUcm4iot.g:384:9: ({...}? => ( ruleKeywordLevel otherlv_11= ':' ( (lv_level_12_0= ruleLevel ) ) ) )
            	    // InternalUcm4iot.g:384:10: {...}? => ( ruleKeywordLevel otherlv_11= ':' ( (lv_level_12_0= ruleLevel ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleExceptionalUseCase", "true");
            	    }
            	    // InternalUcm4iot.g:384:19: ( ruleKeywordLevel otherlv_11= ':' ( (lv_level_12_0= ruleLevel ) ) )
            	    // InternalUcm4iot.g:384:20: ruleKeywordLevel otherlv_11= ':' ( (lv_level_12_0= ruleLevel ) )
            	    {

            	    									newCompositeNode(grammarAccess.getExceptionalUseCaseAccess().getKeywordLevelParserRuleCall_3_2_0());
            	    								
            	    pushFollow(FOLLOW_4);
            	    ruleKeywordLevel();

            	    state._fsp--;


            	    									afterParserOrEnumRuleCall();
            	    								
            	    otherlv_11=(Token)match(input,13,FOLLOW_15); 

            	    									newLeafNode(otherlv_11, grammarAccess.getExceptionalUseCaseAccess().getColonKeyword_3_2_1());
            	    								
            	    // InternalUcm4iot.g:395:9: ( (lv_level_12_0= ruleLevel ) )
            	    // InternalUcm4iot.g:396:10: (lv_level_12_0= ruleLevel )
            	    {
            	    // InternalUcm4iot.g:396:10: (lv_level_12_0= ruleLevel )
            	    // InternalUcm4iot.g:397:11: lv_level_12_0= ruleLevel
            	    {

            	    											newCompositeNode(grammarAccess.getExceptionalUseCaseAccess().getLevelLevelEnumRuleCall_3_2_2_0());
            	    										
            	    pushFollow(FOLLOW_13);
            	    lv_level_12_0=ruleLevel();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getExceptionalUseCaseRule());
            	    											}
            	    											set(
            	    												current,
            	    												"level",
            	    												lv_level_12_0,
            	    												"mde.iot.ucm4iot.Ucm4iot.Level");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalUcm4iot.g:420:4: ({...}? => ( ({...}? => ( ruleKeywordMultiplicity otherlv_14= ':' ( (lv_multiplicity_15_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalUcm4iot.g:420:4: ({...}? => ( ({...}? => ( ruleKeywordMultiplicity otherlv_14= ':' ( (lv_multiplicity_15_0= RULE_STRING ) ) ) ) ) )
            	    // InternalUcm4iot.g:421:5: {...}? => ( ({...}? => ( ruleKeywordMultiplicity otherlv_14= ':' ( (lv_multiplicity_15_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleExceptionalUseCase", "getUnorderedGroupHelper().canSelect(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3(), 3)");
            	    }
            	    // InternalUcm4iot.g:421:115: ( ({...}? => ( ruleKeywordMultiplicity otherlv_14= ':' ( (lv_multiplicity_15_0= RULE_STRING ) ) ) ) )
            	    // InternalUcm4iot.g:422:6: ({...}? => ( ruleKeywordMultiplicity otherlv_14= ':' ( (lv_multiplicity_15_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3(), 3);
            	    					
            	    // InternalUcm4iot.g:425:9: ({...}? => ( ruleKeywordMultiplicity otherlv_14= ':' ( (lv_multiplicity_15_0= RULE_STRING ) ) ) )
            	    // InternalUcm4iot.g:425:10: {...}? => ( ruleKeywordMultiplicity otherlv_14= ':' ( (lv_multiplicity_15_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleExceptionalUseCase", "true");
            	    }
            	    // InternalUcm4iot.g:425:19: ( ruleKeywordMultiplicity otherlv_14= ':' ( (lv_multiplicity_15_0= RULE_STRING ) ) )
            	    // InternalUcm4iot.g:425:20: ruleKeywordMultiplicity otherlv_14= ':' ( (lv_multiplicity_15_0= RULE_STRING ) )
            	    {

            	    									newCompositeNode(grammarAccess.getExceptionalUseCaseAccess().getKeywordMultiplicityParserRuleCall_3_3_0());
            	    								
            	    pushFollow(FOLLOW_4);
            	    ruleKeywordMultiplicity();

            	    state._fsp--;


            	    									afterParserOrEnumRuleCall();
            	    								
            	    otherlv_14=(Token)match(input,13,FOLLOW_14); 

            	    									newLeafNode(otherlv_14, grammarAccess.getExceptionalUseCaseAccess().getColonKeyword_3_3_1());
            	    								
            	    // InternalUcm4iot.g:436:9: ( (lv_multiplicity_15_0= RULE_STRING ) )
            	    // InternalUcm4iot.g:437:10: (lv_multiplicity_15_0= RULE_STRING )
            	    {
            	    // InternalUcm4iot.g:437:10: (lv_multiplicity_15_0= RULE_STRING )
            	    // InternalUcm4iot.g:438:11: lv_multiplicity_15_0= RULE_STRING
            	    {
            	    lv_multiplicity_15_0=(Token)match(input,RULE_STRING,FOLLOW_13); 

            	    											newLeafNode(lv_multiplicity_15_0, grammarAccess.getExceptionalUseCaseAccess().getMultiplicitySTRINGTerminalRuleCall_3_3_2_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getExceptionalUseCaseRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"multiplicity",
            	    												lv_multiplicity_15_0,
            	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalUcm4iot.g:460:4: ({...}? => ( ({...}? => ( ruleKeywordPrecondition otherlv_17= ':' ( (lv_precondition_18_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalUcm4iot.g:460:4: ({...}? => ( ({...}? => ( ruleKeywordPrecondition otherlv_17= ':' ( (lv_precondition_18_0= RULE_STRING ) ) ) ) ) )
            	    // InternalUcm4iot.g:461:5: {...}? => ( ({...}? => ( ruleKeywordPrecondition otherlv_17= ':' ( (lv_precondition_18_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleExceptionalUseCase", "getUnorderedGroupHelper().canSelect(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3(), 4)");
            	    }
            	    // InternalUcm4iot.g:461:115: ( ({...}? => ( ruleKeywordPrecondition otherlv_17= ':' ( (lv_precondition_18_0= RULE_STRING ) ) ) ) )
            	    // InternalUcm4iot.g:462:6: ({...}? => ( ruleKeywordPrecondition otherlv_17= ':' ( (lv_precondition_18_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3(), 4);
            	    					
            	    // InternalUcm4iot.g:465:9: ({...}? => ( ruleKeywordPrecondition otherlv_17= ':' ( (lv_precondition_18_0= RULE_STRING ) ) ) )
            	    // InternalUcm4iot.g:465:10: {...}? => ( ruleKeywordPrecondition otherlv_17= ':' ( (lv_precondition_18_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleExceptionalUseCase", "true");
            	    }
            	    // InternalUcm4iot.g:465:19: ( ruleKeywordPrecondition otherlv_17= ':' ( (lv_precondition_18_0= RULE_STRING ) ) )
            	    // InternalUcm4iot.g:465:20: ruleKeywordPrecondition otherlv_17= ':' ( (lv_precondition_18_0= RULE_STRING ) )
            	    {

            	    									newCompositeNode(grammarAccess.getExceptionalUseCaseAccess().getKeywordPreconditionParserRuleCall_3_4_0());
            	    								
            	    pushFollow(FOLLOW_4);
            	    ruleKeywordPrecondition();

            	    state._fsp--;


            	    									afterParserOrEnumRuleCall();
            	    								
            	    otherlv_17=(Token)match(input,13,FOLLOW_14); 

            	    									newLeafNode(otherlv_17, grammarAccess.getExceptionalUseCaseAccess().getColonKeyword_3_4_1());
            	    								
            	    // InternalUcm4iot.g:476:9: ( (lv_precondition_18_0= RULE_STRING ) )
            	    // InternalUcm4iot.g:477:10: (lv_precondition_18_0= RULE_STRING )
            	    {
            	    // InternalUcm4iot.g:477:10: (lv_precondition_18_0= RULE_STRING )
            	    // InternalUcm4iot.g:478:11: lv_precondition_18_0= RULE_STRING
            	    {
            	    lv_precondition_18_0=(Token)match(input,RULE_STRING,FOLLOW_13); 

            	    											newLeafNode(lv_precondition_18_0, grammarAccess.getExceptionalUseCaseAccess().getPreconditionSTRINGTerminalRuleCall_3_4_2_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getExceptionalUseCaseRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"precondition",
            	    												lv_precondition_18_0,
            	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalUcm4iot.g:500:4: ({...}? => ( ({...}? => ( ruleKeywordPostcondition otherlv_20= ':' ( (lv_postcondition_21_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalUcm4iot.g:500:4: ({...}? => ( ({...}? => ( ruleKeywordPostcondition otherlv_20= ':' ( (lv_postcondition_21_0= RULE_STRING ) ) ) ) ) )
            	    // InternalUcm4iot.g:501:5: {...}? => ( ({...}? => ( ruleKeywordPostcondition otherlv_20= ':' ( (lv_postcondition_21_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleExceptionalUseCase", "getUnorderedGroupHelper().canSelect(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3(), 5)");
            	    }
            	    // InternalUcm4iot.g:501:115: ( ({...}? => ( ruleKeywordPostcondition otherlv_20= ':' ( (lv_postcondition_21_0= RULE_STRING ) ) ) ) )
            	    // InternalUcm4iot.g:502:6: ({...}? => ( ruleKeywordPostcondition otherlv_20= ':' ( (lv_postcondition_21_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3(), 5);
            	    					
            	    // InternalUcm4iot.g:505:9: ({...}? => ( ruleKeywordPostcondition otherlv_20= ':' ( (lv_postcondition_21_0= RULE_STRING ) ) ) )
            	    // InternalUcm4iot.g:505:10: {...}? => ( ruleKeywordPostcondition otherlv_20= ':' ( (lv_postcondition_21_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleExceptionalUseCase", "true");
            	    }
            	    // InternalUcm4iot.g:505:19: ( ruleKeywordPostcondition otherlv_20= ':' ( (lv_postcondition_21_0= RULE_STRING ) ) )
            	    // InternalUcm4iot.g:505:20: ruleKeywordPostcondition otherlv_20= ':' ( (lv_postcondition_21_0= RULE_STRING ) )
            	    {

            	    									newCompositeNode(grammarAccess.getExceptionalUseCaseAccess().getKeywordPostconditionParserRuleCall_3_5_0());
            	    								
            	    pushFollow(FOLLOW_4);
            	    ruleKeywordPostcondition();

            	    state._fsp--;


            	    									afterParserOrEnumRuleCall();
            	    								
            	    otherlv_20=(Token)match(input,13,FOLLOW_14); 

            	    									newLeafNode(otherlv_20, grammarAccess.getExceptionalUseCaseAccess().getColonKeyword_3_5_1());
            	    								
            	    // InternalUcm4iot.g:516:9: ( (lv_postcondition_21_0= RULE_STRING ) )
            	    // InternalUcm4iot.g:517:10: (lv_postcondition_21_0= RULE_STRING )
            	    {
            	    // InternalUcm4iot.g:517:10: (lv_postcondition_21_0= RULE_STRING )
            	    // InternalUcm4iot.g:518:11: lv_postcondition_21_0= RULE_STRING
            	    {
            	    lv_postcondition_21_0=(Token)match(input,RULE_STRING,FOLLOW_13); 

            	    											newLeafNode(lv_postcondition_21_0, grammarAccess.getExceptionalUseCaseAccess().getPostconditionSTRINGTerminalRuleCall_3_5_2_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getExceptionalUseCaseRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"postcondition",
            	    												lv_postcondition_21_0,
            	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // InternalUcm4iot.g:540:4: ({...}? => ( ({...}? => ( ruleKeywordPrimaryActor otherlv_23= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) ) ) ) ) )
            	    {
            	    // InternalUcm4iot.g:540:4: ({...}? => ( ({...}? => ( ruleKeywordPrimaryActor otherlv_23= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) ) ) ) ) )
            	    // InternalUcm4iot.g:541:5: {...}? => ( ({...}? => ( ruleKeywordPrimaryActor otherlv_23= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleExceptionalUseCase", "getUnorderedGroupHelper().canSelect(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3(), 6)");
            	    }
            	    // InternalUcm4iot.g:541:115: ( ({...}? => ( ruleKeywordPrimaryActor otherlv_23= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) ) ) ) )
            	    // InternalUcm4iot.g:542:6: ({...}? => ( ruleKeywordPrimaryActor otherlv_23= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3(), 6);
            	    					
            	    // InternalUcm4iot.g:545:9: ({...}? => ( ruleKeywordPrimaryActor otherlv_23= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) ) ) )
            	    // InternalUcm4iot.g:545:10: {...}? => ( ruleKeywordPrimaryActor otherlv_23= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleExceptionalUseCase", "true");
            	    }
            	    // InternalUcm4iot.g:545:19: ( ruleKeywordPrimaryActor otherlv_23= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) ) )
            	    // InternalUcm4iot.g:545:20: ruleKeywordPrimaryActor otherlv_23= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) )
            	    {

            	    									newCompositeNode(grammarAccess.getExceptionalUseCaseAccess().getKeywordPrimaryActorParserRuleCall_3_6_0());
            	    								
            	    pushFollow(FOLLOW_4);
            	    ruleKeywordPrimaryActor();

            	    state._fsp--;


            	    									afterParserOrEnumRuleCall();
            	    								
            	    otherlv_23=(Token)match(input,13,FOLLOW_16); 

            	    									newLeafNode(otherlv_23, grammarAccess.getExceptionalUseCaseAccess().getColonKeyword_3_6_1());
            	    								
            	    // InternalUcm4iot.g:556:9: ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) )
            	    int alt7=2;
            	    int LA7_0 = input.LA(1);

            	    if ( ((LA7_0>=102 && LA7_0<=105)) ) {
            	        alt7=1;
            	    }
            	    else if ( (LA7_0==RULE_ID||(LA7_0>=27 && LA7_0<=28)) ) {
            	        alt7=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 7, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt7) {
            	        case 1 :
            	            // InternalUcm4iot.g:557:10: ( ruleNotApplicable | ruleNone )
            	            {
            	            // InternalUcm4iot.g:557:10: ( ruleNotApplicable | ruleNone )
            	            int alt6=2;
            	            int LA6_0 = input.LA(1);

            	            if ( ((LA6_0>=104 && LA6_0<=105)) ) {
            	                alt6=1;
            	            }
            	            else if ( ((LA6_0>=102 && LA6_0<=103)) ) {
            	                alt6=2;
            	            }
            	            else {
            	                NoViableAltException nvae =
            	                    new NoViableAltException("", 6, 0, input);

            	                throw nvae;
            	            }
            	            switch (alt6) {
            	                case 1 :
            	                    // InternalUcm4iot.g:558:11: ruleNotApplicable
            	                    {

            	                    											newCompositeNode(grammarAccess.getExceptionalUseCaseAccess().getNotApplicableParserRuleCall_3_6_2_0_0());
            	                    										
            	                    pushFollow(FOLLOW_13);
            	                    ruleNotApplicable();

            	                    state._fsp--;


            	                    											afterParserOrEnumRuleCall();
            	                    										

            	                    }
            	                    break;
            	                case 2 :
            	                    // InternalUcm4iot.g:566:11: ruleNone
            	                    {

            	                    											newCompositeNode(grammarAccess.getExceptionalUseCaseAccess().getNoneParserRuleCall_3_6_2_0_1());
            	                    										
            	                    pushFollow(FOLLOW_13);
            	                    ruleNone();

            	                    state._fsp--;


            	                    											afterParserOrEnumRuleCall();
            	                    										

            	                    }
            	                    break;

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalUcm4iot.g:575:10: ( (lv_primaryActor_26_0= rulePrimaryActor ) )
            	            {
            	            // InternalUcm4iot.g:575:10: ( (lv_primaryActor_26_0= rulePrimaryActor ) )
            	            // InternalUcm4iot.g:576:11: (lv_primaryActor_26_0= rulePrimaryActor )
            	            {
            	            // InternalUcm4iot.g:576:11: (lv_primaryActor_26_0= rulePrimaryActor )
            	            // InternalUcm4iot.g:577:12: lv_primaryActor_26_0= rulePrimaryActor
            	            {

            	            												newCompositeNode(grammarAccess.getExceptionalUseCaseAccess().getPrimaryActorPrimaryActorParserRuleCall_3_6_2_1_0());
            	            											
            	            pushFollow(FOLLOW_13);
            	            lv_primaryActor_26_0=rulePrimaryActor();

            	            state._fsp--;


            	            												if (current==null) {
            	            													current = createModelElementForParent(grammarAccess.getExceptionalUseCaseRule());
            	            												}
            	            												set(
            	            													current,
            	            													"primaryActor",
            	            													lv_primaryActor_26_0,
            	            													"mde.iot.ucm4iot.Ucm4iot.PrimaryActor");
            	            												afterParserOrEnumRuleCall();
            	            											

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // InternalUcm4iot.g:601:4: ({...}? => ( ({...}? => ( ruleKeywordSecondaryActor otherlv_28= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) ) ) ) ) )
            	    {
            	    // InternalUcm4iot.g:601:4: ({...}? => ( ({...}? => ( ruleKeywordSecondaryActor otherlv_28= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) ) ) ) ) )
            	    // InternalUcm4iot.g:602:5: {...}? => ( ({...}? => ( ruleKeywordSecondaryActor otherlv_28= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleExceptionalUseCase", "getUnorderedGroupHelper().canSelect(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3(), 7)");
            	    }
            	    // InternalUcm4iot.g:602:115: ( ({...}? => ( ruleKeywordSecondaryActor otherlv_28= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) ) ) ) )
            	    // InternalUcm4iot.g:603:6: ({...}? => ( ruleKeywordSecondaryActor otherlv_28= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3(), 7);
            	    					
            	    // InternalUcm4iot.g:606:9: ({...}? => ( ruleKeywordSecondaryActor otherlv_28= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) ) ) )
            	    // InternalUcm4iot.g:606:10: {...}? => ( ruleKeywordSecondaryActor otherlv_28= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleExceptionalUseCase", "true");
            	    }
            	    // InternalUcm4iot.g:606:19: ( ruleKeywordSecondaryActor otherlv_28= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) ) )
            	    // InternalUcm4iot.g:606:20: ruleKeywordSecondaryActor otherlv_28= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) )
            	    {

            	    									newCompositeNode(grammarAccess.getExceptionalUseCaseAccess().getKeywordSecondaryActorParserRuleCall_3_7_0());
            	    								
            	    pushFollow(FOLLOW_4);
            	    ruleKeywordSecondaryActor();

            	    state._fsp--;


            	    									afterParserOrEnumRuleCall();
            	    								
            	    otherlv_28=(Token)match(input,13,FOLLOW_17); 

            	    									newLeafNode(otherlv_28, grammarAccess.getExceptionalUseCaseAccess().getColonKeyword_3_7_1());
            	    								
            	    // InternalUcm4iot.g:617:9: ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) )
            	    int alt10=2;
            	    int LA10_0 = input.LA(1);

            	    if ( ((LA10_0>=102 && LA10_0<=105)) ) {
            	        alt10=1;
            	    }
            	    else if ( (LA10_0==RULE_ID||(LA10_0>=27 && LA10_0<=33)) ) {
            	        alt10=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 10, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt10) {
            	        case 1 :
            	            // InternalUcm4iot.g:618:10: ( ruleNotApplicable | ruleNone )
            	            {
            	            // InternalUcm4iot.g:618:10: ( ruleNotApplicable | ruleNone )
            	            int alt8=2;
            	            int LA8_0 = input.LA(1);

            	            if ( ((LA8_0>=104 && LA8_0<=105)) ) {
            	                alt8=1;
            	            }
            	            else if ( ((LA8_0>=102 && LA8_0<=103)) ) {
            	                alt8=2;
            	            }
            	            else {
            	                NoViableAltException nvae =
            	                    new NoViableAltException("", 8, 0, input);

            	                throw nvae;
            	            }
            	            switch (alt8) {
            	                case 1 :
            	                    // InternalUcm4iot.g:619:11: ruleNotApplicable
            	                    {

            	                    											newCompositeNode(grammarAccess.getExceptionalUseCaseAccess().getNotApplicableParserRuleCall_3_7_2_0_0());
            	                    										
            	                    pushFollow(FOLLOW_13);
            	                    ruleNotApplicable();

            	                    state._fsp--;


            	                    											afterParserOrEnumRuleCall();
            	                    										

            	                    }
            	                    break;
            	                case 2 :
            	                    // InternalUcm4iot.g:627:11: ruleNone
            	                    {

            	                    											newCompositeNode(grammarAccess.getExceptionalUseCaseAccess().getNoneParserRuleCall_3_7_2_0_1());
            	                    										
            	                    pushFollow(FOLLOW_13);
            	                    ruleNone();

            	                    state._fsp--;


            	                    											afterParserOrEnumRuleCall();
            	                    										

            	                    }
            	                    break;

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalUcm4iot.g:636:10: ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* )
            	            {
            	            // InternalUcm4iot.g:636:10: ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* )
            	            // InternalUcm4iot.g:637:11: ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )*
            	            {
            	            // InternalUcm4iot.g:637:11: ( (lv_secondaryActors_31_0= ruleSecondaryActor ) )
            	            // InternalUcm4iot.g:638:12: (lv_secondaryActors_31_0= ruleSecondaryActor )
            	            {
            	            // InternalUcm4iot.g:638:12: (lv_secondaryActors_31_0= ruleSecondaryActor )
            	            // InternalUcm4iot.g:639:13: lv_secondaryActors_31_0= ruleSecondaryActor
            	            {

            	            													newCompositeNode(grammarAccess.getExceptionalUseCaseAccess().getSecondaryActorsSecondaryActorParserRuleCall_3_7_2_1_0_0());
            	            												
            	            pushFollow(FOLLOW_18);
            	            lv_secondaryActors_31_0=ruleSecondaryActor();

            	            state._fsp--;


            	            													if (current==null) {
            	            														current = createModelElementForParent(grammarAccess.getExceptionalUseCaseRule());
            	            													}
            	            													add(
            	            														current,
            	            														"secondaryActors",
            	            														lv_secondaryActors_31_0,
            	            														"mde.iot.ucm4iot.Ucm4iot.SecondaryActor");
            	            													afterParserOrEnumRuleCall();
            	            												

            	            }


            	            }

            	            // InternalUcm4iot.g:656:11: (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )*
            	            loop9:
            	            do {
            	                int alt9=2;
            	                int LA9_0 = input.LA(1);

            	                if ( (LA9_0==16) ) {
            	                    alt9=1;
            	                }


            	                switch (alt9) {
            	            	case 1 :
            	            	    // InternalUcm4iot.g:657:12: otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) )
            	            	    {
            	            	    otherlv_32=(Token)match(input,16,FOLLOW_17); 

            	            	    												newLeafNode(otherlv_32, grammarAccess.getExceptionalUseCaseAccess().getCommaKeyword_3_7_2_1_1_0());
            	            	    											
            	            	    // InternalUcm4iot.g:661:12: ( (lv_secondaryActors_33_0= ruleSecondaryActor ) )
            	            	    // InternalUcm4iot.g:662:13: (lv_secondaryActors_33_0= ruleSecondaryActor )
            	            	    {
            	            	    // InternalUcm4iot.g:662:13: (lv_secondaryActors_33_0= ruleSecondaryActor )
            	            	    // InternalUcm4iot.g:663:14: lv_secondaryActors_33_0= ruleSecondaryActor
            	            	    {

            	            	    														newCompositeNode(grammarAccess.getExceptionalUseCaseAccess().getSecondaryActorsSecondaryActorParserRuleCall_3_7_2_1_1_1_0());
            	            	    													
            	            	    pushFollow(FOLLOW_18);
            	            	    lv_secondaryActors_33_0=ruleSecondaryActor();

            	            	    state._fsp--;


            	            	    														if (current==null) {
            	            	    															current = createModelElementForParent(grammarAccess.getExceptionalUseCaseRule());
            	            	    														}
            	            	    														add(
            	            	    															current,
            	            	    															"secondaryActors",
            	            	    															lv_secondaryActors_33_0,
            	            	    															"mde.iot.ucm4iot.Ucm4iot.SecondaryActor");
            	            	    														afterParserOrEnumRuleCall();
            	            	    													

            	            	    }


            	            	    }


            	            	    }
            	            	    break;

            	            	default :
            	            	    break loop9;
            	                }
            	            } while (true);


            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 9 :
            	    // InternalUcm4iot.g:689:4: ({...}? => ( ({...}? => ( ruleKeywordFacilitatorActor otherlv_35= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) ) ) ) ) )
            	    {
            	    // InternalUcm4iot.g:689:4: ({...}? => ( ({...}? => ( ruleKeywordFacilitatorActor otherlv_35= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) ) ) ) ) )
            	    // InternalUcm4iot.g:690:5: {...}? => ( ({...}? => ( ruleKeywordFacilitatorActor otherlv_35= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3(), 8) ) {
            	        throw new FailedPredicateException(input, "ruleExceptionalUseCase", "getUnorderedGroupHelper().canSelect(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3(), 8)");
            	    }
            	    // InternalUcm4iot.g:690:115: ( ({...}? => ( ruleKeywordFacilitatorActor otherlv_35= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) ) ) ) )
            	    // InternalUcm4iot.g:691:6: ({...}? => ( ruleKeywordFacilitatorActor otherlv_35= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3(), 8);
            	    					
            	    // InternalUcm4iot.g:694:9: ({...}? => ( ruleKeywordFacilitatorActor otherlv_35= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) ) ) )
            	    // InternalUcm4iot.g:694:10: {...}? => ( ruleKeywordFacilitatorActor otherlv_35= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleExceptionalUseCase", "true");
            	    }
            	    // InternalUcm4iot.g:694:19: ( ruleKeywordFacilitatorActor otherlv_35= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) ) )
            	    // InternalUcm4iot.g:694:20: ruleKeywordFacilitatorActor otherlv_35= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) )
            	    {

            	    									newCompositeNode(grammarAccess.getExceptionalUseCaseAccess().getKeywordFacilitatorActorParserRuleCall_3_8_0());
            	    								
            	    pushFollow(FOLLOW_4);
            	    ruleKeywordFacilitatorActor();

            	    state._fsp--;


            	    									afterParserOrEnumRuleCall();
            	    								
            	    otherlv_35=(Token)match(input,13,FOLLOW_17); 

            	    									newLeafNode(otherlv_35, grammarAccess.getExceptionalUseCaseAccess().getColonKeyword_3_8_1());
            	    								
            	    // InternalUcm4iot.g:705:9: ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) )
            	    int alt13=2;
            	    int LA13_0 = input.LA(1);

            	    if ( ((LA13_0>=102 && LA13_0<=105)) ) {
            	        alt13=1;
            	    }
            	    else if ( (LA13_0==RULE_ID||(LA13_0>=27 && LA13_0<=33)) ) {
            	        alt13=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 13, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt13) {
            	        case 1 :
            	            // InternalUcm4iot.g:706:10: ( ruleNotApplicable | ruleNone )
            	            {
            	            // InternalUcm4iot.g:706:10: ( ruleNotApplicable | ruleNone )
            	            int alt11=2;
            	            int LA11_0 = input.LA(1);

            	            if ( ((LA11_0>=104 && LA11_0<=105)) ) {
            	                alt11=1;
            	            }
            	            else if ( ((LA11_0>=102 && LA11_0<=103)) ) {
            	                alt11=2;
            	            }
            	            else {
            	                NoViableAltException nvae =
            	                    new NoViableAltException("", 11, 0, input);

            	                throw nvae;
            	            }
            	            switch (alt11) {
            	                case 1 :
            	                    // InternalUcm4iot.g:707:11: ruleNotApplicable
            	                    {

            	                    											newCompositeNode(grammarAccess.getExceptionalUseCaseAccess().getNotApplicableParserRuleCall_3_8_2_0_0());
            	                    										
            	                    pushFollow(FOLLOW_13);
            	                    ruleNotApplicable();

            	                    state._fsp--;


            	                    											afterParserOrEnumRuleCall();
            	                    										

            	                    }
            	                    break;
            	                case 2 :
            	                    // InternalUcm4iot.g:715:11: ruleNone
            	                    {

            	                    											newCompositeNode(grammarAccess.getExceptionalUseCaseAccess().getNoneParserRuleCall_3_8_2_0_1());
            	                    										
            	                    pushFollow(FOLLOW_13);
            	                    ruleNone();

            	                    state._fsp--;


            	                    											afterParserOrEnumRuleCall();
            	                    										

            	                    }
            	                    break;

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalUcm4iot.g:724:10: ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* )
            	            {
            	            // InternalUcm4iot.g:724:10: ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* )
            	            // InternalUcm4iot.g:725:11: ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )*
            	            {
            	            // InternalUcm4iot.g:725:11: ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) )
            	            // InternalUcm4iot.g:726:12: (lv_facilitatorActors_38_0= ruleSecondaryActor )
            	            {
            	            // InternalUcm4iot.g:726:12: (lv_facilitatorActors_38_0= ruleSecondaryActor )
            	            // InternalUcm4iot.g:727:13: lv_facilitatorActors_38_0= ruleSecondaryActor
            	            {

            	            													newCompositeNode(grammarAccess.getExceptionalUseCaseAccess().getFacilitatorActorsSecondaryActorParserRuleCall_3_8_2_1_0_0());
            	            												
            	            pushFollow(FOLLOW_18);
            	            lv_facilitatorActors_38_0=ruleSecondaryActor();

            	            state._fsp--;


            	            													if (current==null) {
            	            														current = createModelElementForParent(grammarAccess.getExceptionalUseCaseRule());
            	            													}
            	            													add(
            	            														current,
            	            														"facilitatorActors",
            	            														lv_facilitatorActors_38_0,
            	            														"mde.iot.ucm4iot.Ucm4iot.SecondaryActor");
            	            													afterParserOrEnumRuleCall();
            	            												

            	            }


            	            }

            	            // InternalUcm4iot.g:744:11: (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )*
            	            loop12:
            	            do {
            	                int alt12=2;
            	                int LA12_0 = input.LA(1);

            	                if ( (LA12_0==16) ) {
            	                    alt12=1;
            	                }


            	                switch (alt12) {
            	            	case 1 :
            	            	    // InternalUcm4iot.g:745:12: otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) )
            	            	    {
            	            	    otherlv_39=(Token)match(input,16,FOLLOW_17); 

            	            	    												newLeafNode(otherlv_39, grammarAccess.getExceptionalUseCaseAccess().getCommaKeyword_3_8_2_1_1_0());
            	            	    											
            	            	    // InternalUcm4iot.g:749:12: ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) )
            	            	    // InternalUcm4iot.g:750:13: (lv_facilitatorActors_40_0= ruleSecondaryActor )
            	            	    {
            	            	    // InternalUcm4iot.g:750:13: (lv_facilitatorActors_40_0= ruleSecondaryActor )
            	            	    // InternalUcm4iot.g:751:14: lv_facilitatorActors_40_0= ruleSecondaryActor
            	            	    {

            	            	    														newCompositeNode(grammarAccess.getExceptionalUseCaseAccess().getFacilitatorActorsSecondaryActorParserRuleCall_3_8_2_1_1_1_0());
            	            	    													
            	            	    pushFollow(FOLLOW_18);
            	            	    lv_facilitatorActors_40_0=ruleSecondaryActor();

            	            	    state._fsp--;


            	            	    														if (current==null) {
            	            	    															current = createModelElementForParent(grammarAccess.getExceptionalUseCaseRule());
            	            	    														}
            	            	    														add(
            	            	    															current,
            	            	    															"facilitatorActors",
            	            	    															lv_facilitatorActors_40_0,
            	            	    															"mde.iot.ucm4iot.Ucm4iot.SecondaryActor");
            	            	    														afterParserOrEnumRuleCall();
            	            	    													

            	            	    }


            	            	    }


            	            	    }
            	            	    break;

            	            	default :
            	            	    break loop12;
            	                }
            	            } while (true);


            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3()) ) {
                throw new FailedPredicateException(input, "ruleExceptionalUseCase", "getUnorderedGroupHelper().canLeave(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3())");
            }

            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3());
            				

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExceptionalUseCase"


    // $ANTLR start "entryRuleHandlerUseCase"
    // InternalUcm4iot.g:789:1: entryRuleHandlerUseCase returns [EObject current=null] : iv_ruleHandlerUseCase= ruleHandlerUseCase EOF ;
    public final EObject entryRuleHandlerUseCase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHandlerUseCase = null;


        try {
            // InternalUcm4iot.g:789:55: (iv_ruleHandlerUseCase= ruleHandlerUseCase EOF )
            // InternalUcm4iot.g:790:2: iv_ruleHandlerUseCase= ruleHandlerUseCase EOF
            {
             newCompositeNode(grammarAccess.getHandlerUseCaseRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleHandlerUseCase=ruleHandlerUseCase();

            state._fsp--;

             current =iv_ruleHandlerUseCase; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHandlerUseCase"


    // $ANTLR start "ruleHandlerUseCase"
    // InternalUcm4iot.g:796:1: ruleHandlerUseCase returns [EObject current=null] : ( ruleKeywordHandlerUseCase otherlv_1= ':' ( (lv_name_2_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => ( ruleKeywordScope otherlv_5= ':' ( (lv_scope_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordIntention otherlv_8= ':' ( (lv_intent_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordLevel otherlv_11= ':' ( (lv_level_12_0= ruleLevel ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordMultiplicity otherlv_14= ':' ( (lv_multiplicity_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrecondition otherlv_17= ':' ( (lv_precondition_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPostcondition otherlv_20= ':' ( (lv_postcondition_21_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrimaryActor otherlv_23= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordSecondaryActor otherlv_28= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordFacilitatorActor otherlv_35= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordHandlerClass otherlv_42= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_handlerClass_45_0= RULE_ID ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordContextException otherlv_47= ':' ( (lv_contextExceptions_48_0= ruleContextExceptionMapping ) ) (otherlv_49= ',' ( (lv_contextExceptions_50_0= ruleContextExceptionMapping ) ) )* ) ) ) ) )+ {...}?) ) ) ) ;
    public final EObject ruleHandlerUseCase() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_5=null;
        Token lv_scope_6_0=null;
        Token otherlv_8=null;
        Token lv_intent_9_0=null;
        Token otherlv_11=null;
        Token otherlv_14=null;
        Token lv_multiplicity_15_0=null;
        Token otherlv_17=null;
        Token lv_precondition_18_0=null;
        Token otherlv_20=null;
        Token lv_postcondition_21_0=null;
        Token otherlv_23=null;
        Token otherlv_28=null;
        Token otherlv_32=null;
        Token otherlv_35=null;
        Token otherlv_39=null;
        Token otherlv_42=null;
        Token lv_handlerClass_45_0=null;
        Token otherlv_47=null;
        Token otherlv_49=null;
        Enumerator lv_level_12_0 = null;

        EObject lv_primaryActor_26_0 = null;

        EObject lv_secondaryActors_31_0 = null;

        EObject lv_secondaryActors_33_0 = null;

        EObject lv_facilitatorActors_38_0 = null;

        EObject lv_facilitatorActors_40_0 = null;

        EObject lv_contextExceptions_48_0 = null;

        EObject lv_contextExceptions_50_0 = null;



        	enterRule();

        try {
            // InternalUcm4iot.g:802:2: ( ( ruleKeywordHandlerUseCase otherlv_1= ':' ( (lv_name_2_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => ( ruleKeywordScope otherlv_5= ':' ( (lv_scope_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordIntention otherlv_8= ':' ( (lv_intent_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordLevel otherlv_11= ':' ( (lv_level_12_0= ruleLevel ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordMultiplicity otherlv_14= ':' ( (lv_multiplicity_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrecondition otherlv_17= ':' ( (lv_precondition_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPostcondition otherlv_20= ':' ( (lv_postcondition_21_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrimaryActor otherlv_23= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordSecondaryActor otherlv_28= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordFacilitatorActor otherlv_35= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordHandlerClass otherlv_42= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_handlerClass_45_0= RULE_ID ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordContextException otherlv_47= ':' ( (lv_contextExceptions_48_0= ruleContextExceptionMapping ) ) (otherlv_49= ',' ( (lv_contextExceptions_50_0= ruleContextExceptionMapping ) ) )* ) ) ) ) )+ {...}?) ) ) ) )
            // InternalUcm4iot.g:803:2: ( ruleKeywordHandlerUseCase otherlv_1= ':' ( (lv_name_2_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => ( ruleKeywordScope otherlv_5= ':' ( (lv_scope_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordIntention otherlv_8= ':' ( (lv_intent_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordLevel otherlv_11= ':' ( (lv_level_12_0= ruleLevel ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordMultiplicity otherlv_14= ':' ( (lv_multiplicity_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrecondition otherlv_17= ':' ( (lv_precondition_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPostcondition otherlv_20= ':' ( (lv_postcondition_21_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrimaryActor otherlv_23= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordSecondaryActor otherlv_28= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordFacilitatorActor otherlv_35= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordHandlerClass otherlv_42= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_handlerClass_45_0= RULE_ID ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordContextException otherlv_47= ':' ( (lv_contextExceptions_48_0= ruleContextExceptionMapping ) ) (otherlv_49= ',' ( (lv_contextExceptions_50_0= ruleContextExceptionMapping ) ) )* ) ) ) ) )+ {...}?) ) ) )
            {
            // InternalUcm4iot.g:803:2: ( ruleKeywordHandlerUseCase otherlv_1= ':' ( (lv_name_2_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => ( ruleKeywordScope otherlv_5= ':' ( (lv_scope_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordIntention otherlv_8= ':' ( (lv_intent_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordLevel otherlv_11= ':' ( (lv_level_12_0= ruleLevel ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordMultiplicity otherlv_14= ':' ( (lv_multiplicity_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrecondition otherlv_17= ':' ( (lv_precondition_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPostcondition otherlv_20= ':' ( (lv_postcondition_21_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrimaryActor otherlv_23= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordSecondaryActor otherlv_28= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordFacilitatorActor otherlv_35= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordHandlerClass otherlv_42= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_handlerClass_45_0= RULE_ID ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordContextException otherlv_47= ':' ( (lv_contextExceptions_48_0= ruleContextExceptionMapping ) ) (otherlv_49= ',' ( (lv_contextExceptions_50_0= ruleContextExceptionMapping ) ) )* ) ) ) ) )+ {...}?) ) ) )
            // InternalUcm4iot.g:804:3: ruleKeywordHandlerUseCase otherlv_1= ':' ( (lv_name_2_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => ( ruleKeywordScope otherlv_5= ':' ( (lv_scope_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordIntention otherlv_8= ':' ( (lv_intent_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordLevel otherlv_11= ':' ( (lv_level_12_0= ruleLevel ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordMultiplicity otherlv_14= ':' ( (lv_multiplicity_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrecondition otherlv_17= ':' ( (lv_precondition_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPostcondition otherlv_20= ':' ( (lv_postcondition_21_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrimaryActor otherlv_23= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordSecondaryActor otherlv_28= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordFacilitatorActor otherlv_35= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordHandlerClass otherlv_42= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_handlerClass_45_0= RULE_ID ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordContextException otherlv_47= ':' ( (lv_contextExceptions_48_0= ruleContextExceptionMapping ) ) (otherlv_49= ',' ( (lv_contextExceptions_50_0= ruleContextExceptionMapping ) ) )* ) ) ) ) )+ {...}?) ) )
            {

            			newCompositeNode(grammarAccess.getHandlerUseCaseAccess().getKeywordHandlerUseCaseParserRuleCall_0());
            		
            pushFollow(FOLLOW_4);
            ruleKeywordHandlerUseCase();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		
            otherlv_1=(Token)match(input,13,FOLLOW_11); 

            			newLeafNode(otherlv_1, grammarAccess.getHandlerUseCaseAccess().getColonKeyword_1());
            		
            // InternalUcm4iot.g:815:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalUcm4iot.g:816:4: (lv_name_2_0= RULE_ID )
            {
            // InternalUcm4iot.g:816:4: (lv_name_2_0= RULE_ID )
            // InternalUcm4iot.g:817:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_19); 

            					newLeafNode(lv_name_2_0, grammarAccess.getHandlerUseCaseAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHandlerUseCaseRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalUcm4iot.g:833:3: ( ( ( ( ({...}? => ( ({...}? => ( ruleKeywordScope otherlv_5= ':' ( (lv_scope_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordIntention otherlv_8= ':' ( (lv_intent_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordLevel otherlv_11= ':' ( (lv_level_12_0= ruleLevel ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordMultiplicity otherlv_14= ':' ( (lv_multiplicity_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrecondition otherlv_17= ':' ( (lv_precondition_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPostcondition otherlv_20= ':' ( (lv_postcondition_21_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrimaryActor otherlv_23= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordSecondaryActor otherlv_28= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordFacilitatorActor otherlv_35= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordHandlerClass otherlv_42= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_handlerClass_45_0= RULE_ID ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordContextException otherlv_47= ':' ( (lv_contextExceptions_48_0= ruleContextExceptionMapping ) ) (otherlv_49= ',' ( (lv_contextExceptions_50_0= ruleContextExceptionMapping ) ) )* ) ) ) ) )+ {...}?) ) )
            // InternalUcm4iot.g:834:4: ( ( ( ({...}? => ( ({...}? => ( ruleKeywordScope otherlv_5= ':' ( (lv_scope_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordIntention otherlv_8= ':' ( (lv_intent_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordLevel otherlv_11= ':' ( (lv_level_12_0= ruleLevel ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordMultiplicity otherlv_14= ':' ( (lv_multiplicity_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrecondition otherlv_17= ':' ( (lv_precondition_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPostcondition otherlv_20= ':' ( (lv_postcondition_21_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrimaryActor otherlv_23= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordSecondaryActor otherlv_28= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordFacilitatorActor otherlv_35= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordHandlerClass otherlv_42= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_handlerClass_45_0= RULE_ID ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordContextException otherlv_47= ':' ( (lv_contextExceptions_48_0= ruleContextExceptionMapping ) ) (otherlv_49= ',' ( (lv_contextExceptions_50_0= ruleContextExceptionMapping ) ) )* ) ) ) ) )+ {...}?) )
            {
            // InternalUcm4iot.g:834:4: ( ( ( ({...}? => ( ({...}? => ( ruleKeywordScope otherlv_5= ':' ( (lv_scope_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordIntention otherlv_8= ':' ( (lv_intent_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordLevel otherlv_11= ':' ( (lv_level_12_0= ruleLevel ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordMultiplicity otherlv_14= ':' ( (lv_multiplicity_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrecondition otherlv_17= ':' ( (lv_precondition_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPostcondition otherlv_20= ':' ( (lv_postcondition_21_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrimaryActor otherlv_23= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordSecondaryActor otherlv_28= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordFacilitatorActor otherlv_35= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordHandlerClass otherlv_42= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_handlerClass_45_0= RULE_ID ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordContextException otherlv_47= ':' ( (lv_contextExceptions_48_0= ruleContextExceptionMapping ) ) (otherlv_49= ',' ( (lv_contextExceptions_50_0= ruleContextExceptionMapping ) ) )* ) ) ) ) )+ {...}?) )
            // InternalUcm4iot.g:835:5: ( ( ({...}? => ( ({...}? => ( ruleKeywordScope otherlv_5= ':' ( (lv_scope_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordIntention otherlv_8= ':' ( (lv_intent_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordLevel otherlv_11= ':' ( (lv_level_12_0= ruleLevel ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordMultiplicity otherlv_14= ':' ( (lv_multiplicity_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrecondition otherlv_17= ':' ( (lv_precondition_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPostcondition otherlv_20= ':' ( (lv_postcondition_21_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrimaryActor otherlv_23= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordSecondaryActor otherlv_28= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordFacilitatorActor otherlv_35= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordHandlerClass otherlv_42= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_handlerClass_45_0= RULE_ID ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordContextException otherlv_47= ':' ( (lv_contextExceptions_48_0= ruleContextExceptionMapping ) ) (otherlv_49= ',' ( (lv_contextExceptions_50_0= ruleContextExceptionMapping ) ) )* ) ) ) ) )+ {...}?)
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3());
            				
            // InternalUcm4iot.g:838:5: ( ( ({...}? => ( ({...}? => ( ruleKeywordScope otherlv_5= ':' ( (lv_scope_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordIntention otherlv_8= ':' ( (lv_intent_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordLevel otherlv_11= ':' ( (lv_level_12_0= ruleLevel ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordMultiplicity otherlv_14= ':' ( (lv_multiplicity_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrecondition otherlv_17= ':' ( (lv_precondition_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPostcondition otherlv_20= ':' ( (lv_postcondition_21_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrimaryActor otherlv_23= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordSecondaryActor otherlv_28= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordFacilitatorActor otherlv_35= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordHandlerClass otherlv_42= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_handlerClass_45_0= RULE_ID ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordContextException otherlv_47= ':' ( (lv_contextExceptions_48_0= ruleContextExceptionMapping ) ) (otherlv_49= ',' ( (lv_contextExceptions_50_0= ruleContextExceptionMapping ) ) )* ) ) ) ) )+ {...}?)
            // InternalUcm4iot.g:839:6: ( ({...}? => ( ({...}? => ( ruleKeywordScope otherlv_5= ':' ( (lv_scope_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordIntention otherlv_8= ':' ( (lv_intent_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordLevel otherlv_11= ':' ( (lv_level_12_0= ruleLevel ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordMultiplicity otherlv_14= ':' ( (lv_multiplicity_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrecondition otherlv_17= ':' ( (lv_precondition_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPostcondition otherlv_20= ':' ( (lv_postcondition_21_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrimaryActor otherlv_23= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordSecondaryActor otherlv_28= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordFacilitatorActor otherlv_35= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordHandlerClass otherlv_42= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_handlerClass_45_0= RULE_ID ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordContextException otherlv_47= ':' ( (lv_contextExceptions_48_0= ruleContextExceptionMapping ) ) (otherlv_49= ',' ( (lv_contextExceptions_50_0= ruleContextExceptionMapping ) ) )* ) ) ) ) )+ {...}?
            {
            // InternalUcm4iot.g:839:6: ( ({...}? => ( ({...}? => ( ruleKeywordScope otherlv_5= ':' ( (lv_scope_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordIntention otherlv_8= ':' ( (lv_intent_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordLevel otherlv_11= ':' ( (lv_level_12_0= ruleLevel ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordMultiplicity otherlv_14= ':' ( (lv_multiplicity_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrecondition otherlv_17= ':' ( (lv_precondition_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPostcondition otherlv_20= ':' ( (lv_postcondition_21_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrimaryActor otherlv_23= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordSecondaryActor otherlv_28= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordFacilitatorActor otherlv_35= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordHandlerClass otherlv_42= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_handlerClass_45_0= RULE_ID ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordContextException otherlv_47= ':' ( (lv_contextExceptions_48_0= ruleContextExceptionMapping ) ) (otherlv_49= ',' ( (lv_contextExceptions_50_0= ruleContextExceptionMapping ) ) )* ) ) ) ) )+
            int cnt26=0;
            loop26:
            do {
                int alt26=12;
                alt26 = dfa26.predict(input);
                switch (alt26) {
            	case 1 :
            	    // InternalUcm4iot.g:840:4: ({...}? => ( ({...}? => ( ruleKeywordScope otherlv_5= ':' ( (lv_scope_6_0= RULE_ID ) ) ) ) ) )
            	    {
            	    // InternalUcm4iot.g:840:4: ({...}? => ( ({...}? => ( ruleKeywordScope otherlv_5= ':' ( (lv_scope_6_0= RULE_ID ) ) ) ) ) )
            	    // InternalUcm4iot.g:841:5: {...}? => ( ({...}? => ( ruleKeywordScope otherlv_5= ':' ( (lv_scope_6_0= RULE_ID ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleHandlerUseCase", "getUnorderedGroupHelper().canSelect(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // InternalUcm4iot.g:841:111: ( ({...}? => ( ruleKeywordScope otherlv_5= ':' ( (lv_scope_6_0= RULE_ID ) ) ) ) )
            	    // InternalUcm4iot.g:842:6: ({...}? => ( ruleKeywordScope otherlv_5= ':' ( (lv_scope_6_0= RULE_ID ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3(), 0);
            	    					
            	    // InternalUcm4iot.g:845:9: ({...}? => ( ruleKeywordScope otherlv_5= ':' ( (lv_scope_6_0= RULE_ID ) ) ) )
            	    // InternalUcm4iot.g:845:10: {...}? => ( ruleKeywordScope otherlv_5= ':' ( (lv_scope_6_0= RULE_ID ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHandlerUseCase", "true");
            	    }
            	    // InternalUcm4iot.g:845:19: ( ruleKeywordScope otherlv_5= ':' ( (lv_scope_6_0= RULE_ID ) ) )
            	    // InternalUcm4iot.g:845:20: ruleKeywordScope otherlv_5= ':' ( (lv_scope_6_0= RULE_ID ) )
            	    {

            	    									newCompositeNode(grammarAccess.getHandlerUseCaseAccess().getKeywordScopeParserRuleCall_3_0_0());
            	    								
            	    pushFollow(FOLLOW_4);
            	    ruleKeywordScope();

            	    state._fsp--;


            	    									afterParserOrEnumRuleCall();
            	    								
            	    otherlv_5=(Token)match(input,13,FOLLOW_11); 

            	    									newLeafNode(otherlv_5, grammarAccess.getHandlerUseCaseAccess().getColonKeyword_3_0_1());
            	    								
            	    // InternalUcm4iot.g:856:9: ( (lv_scope_6_0= RULE_ID ) )
            	    // InternalUcm4iot.g:857:10: (lv_scope_6_0= RULE_ID )
            	    {
            	    // InternalUcm4iot.g:857:10: (lv_scope_6_0= RULE_ID )
            	    // InternalUcm4iot.g:858:11: lv_scope_6_0= RULE_ID
            	    {
            	    lv_scope_6_0=(Token)match(input,RULE_ID,FOLLOW_20); 

            	    											newLeafNode(lv_scope_6_0, grammarAccess.getHandlerUseCaseAccess().getScopeIDTerminalRuleCall_3_0_2_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getHandlerUseCaseRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"scope",
            	    												lv_scope_6_0,
            	    												"org.eclipse.xtext.common.Terminals.ID");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalUcm4iot.g:880:4: ({...}? => ( ({...}? => ( ruleKeywordIntention otherlv_8= ':' ( (lv_intent_9_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalUcm4iot.g:880:4: ({...}? => ( ({...}? => ( ruleKeywordIntention otherlv_8= ':' ( (lv_intent_9_0= RULE_STRING ) ) ) ) ) )
            	    // InternalUcm4iot.g:881:5: {...}? => ( ({...}? => ( ruleKeywordIntention otherlv_8= ':' ( (lv_intent_9_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleHandlerUseCase", "getUnorderedGroupHelper().canSelect(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // InternalUcm4iot.g:881:111: ( ({...}? => ( ruleKeywordIntention otherlv_8= ':' ( (lv_intent_9_0= RULE_STRING ) ) ) ) )
            	    // InternalUcm4iot.g:882:6: ({...}? => ( ruleKeywordIntention otherlv_8= ':' ( (lv_intent_9_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3(), 1);
            	    					
            	    // InternalUcm4iot.g:885:9: ({...}? => ( ruleKeywordIntention otherlv_8= ':' ( (lv_intent_9_0= RULE_STRING ) ) ) )
            	    // InternalUcm4iot.g:885:10: {...}? => ( ruleKeywordIntention otherlv_8= ':' ( (lv_intent_9_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHandlerUseCase", "true");
            	    }
            	    // InternalUcm4iot.g:885:19: ( ruleKeywordIntention otherlv_8= ':' ( (lv_intent_9_0= RULE_STRING ) ) )
            	    // InternalUcm4iot.g:885:20: ruleKeywordIntention otherlv_8= ':' ( (lv_intent_9_0= RULE_STRING ) )
            	    {

            	    									newCompositeNode(grammarAccess.getHandlerUseCaseAccess().getKeywordIntentionParserRuleCall_3_1_0());
            	    								
            	    pushFollow(FOLLOW_4);
            	    ruleKeywordIntention();

            	    state._fsp--;


            	    									afterParserOrEnumRuleCall();
            	    								
            	    otherlv_8=(Token)match(input,13,FOLLOW_14); 

            	    									newLeafNode(otherlv_8, grammarAccess.getHandlerUseCaseAccess().getColonKeyword_3_1_1());
            	    								
            	    // InternalUcm4iot.g:896:9: ( (lv_intent_9_0= RULE_STRING ) )
            	    // InternalUcm4iot.g:897:10: (lv_intent_9_0= RULE_STRING )
            	    {
            	    // InternalUcm4iot.g:897:10: (lv_intent_9_0= RULE_STRING )
            	    // InternalUcm4iot.g:898:11: lv_intent_9_0= RULE_STRING
            	    {
            	    lv_intent_9_0=(Token)match(input,RULE_STRING,FOLLOW_20); 

            	    											newLeafNode(lv_intent_9_0, grammarAccess.getHandlerUseCaseAccess().getIntentSTRINGTerminalRuleCall_3_1_2_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getHandlerUseCaseRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"intent",
            	    												lv_intent_9_0,
            	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalUcm4iot.g:920:4: ({...}? => ( ({...}? => ( ruleKeywordLevel otherlv_11= ':' ( (lv_level_12_0= ruleLevel ) ) ) ) ) )
            	    {
            	    // InternalUcm4iot.g:920:4: ({...}? => ( ({...}? => ( ruleKeywordLevel otherlv_11= ':' ( (lv_level_12_0= ruleLevel ) ) ) ) ) )
            	    // InternalUcm4iot.g:921:5: {...}? => ( ({...}? => ( ruleKeywordLevel otherlv_11= ':' ( (lv_level_12_0= ruleLevel ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleHandlerUseCase", "getUnorderedGroupHelper().canSelect(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // InternalUcm4iot.g:921:111: ( ({...}? => ( ruleKeywordLevel otherlv_11= ':' ( (lv_level_12_0= ruleLevel ) ) ) ) )
            	    // InternalUcm4iot.g:922:6: ({...}? => ( ruleKeywordLevel otherlv_11= ':' ( (lv_level_12_0= ruleLevel ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3(), 2);
            	    					
            	    // InternalUcm4iot.g:925:9: ({...}? => ( ruleKeywordLevel otherlv_11= ':' ( (lv_level_12_0= ruleLevel ) ) ) )
            	    // InternalUcm4iot.g:925:10: {...}? => ( ruleKeywordLevel otherlv_11= ':' ( (lv_level_12_0= ruleLevel ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHandlerUseCase", "true");
            	    }
            	    // InternalUcm4iot.g:925:19: ( ruleKeywordLevel otherlv_11= ':' ( (lv_level_12_0= ruleLevel ) ) )
            	    // InternalUcm4iot.g:925:20: ruleKeywordLevel otherlv_11= ':' ( (lv_level_12_0= ruleLevel ) )
            	    {

            	    									newCompositeNode(grammarAccess.getHandlerUseCaseAccess().getKeywordLevelParserRuleCall_3_2_0());
            	    								
            	    pushFollow(FOLLOW_4);
            	    ruleKeywordLevel();

            	    state._fsp--;


            	    									afterParserOrEnumRuleCall();
            	    								
            	    otherlv_11=(Token)match(input,13,FOLLOW_15); 

            	    									newLeafNode(otherlv_11, grammarAccess.getHandlerUseCaseAccess().getColonKeyword_3_2_1());
            	    								
            	    // InternalUcm4iot.g:936:9: ( (lv_level_12_0= ruleLevel ) )
            	    // InternalUcm4iot.g:937:10: (lv_level_12_0= ruleLevel )
            	    {
            	    // InternalUcm4iot.g:937:10: (lv_level_12_0= ruleLevel )
            	    // InternalUcm4iot.g:938:11: lv_level_12_0= ruleLevel
            	    {

            	    											newCompositeNode(grammarAccess.getHandlerUseCaseAccess().getLevelLevelEnumRuleCall_3_2_2_0());
            	    										
            	    pushFollow(FOLLOW_20);
            	    lv_level_12_0=ruleLevel();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getHandlerUseCaseRule());
            	    											}
            	    											set(
            	    												current,
            	    												"level",
            	    												lv_level_12_0,
            	    												"mde.iot.ucm4iot.Ucm4iot.Level");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalUcm4iot.g:961:4: ({...}? => ( ({...}? => ( ruleKeywordMultiplicity otherlv_14= ':' ( (lv_multiplicity_15_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalUcm4iot.g:961:4: ({...}? => ( ({...}? => ( ruleKeywordMultiplicity otherlv_14= ':' ( (lv_multiplicity_15_0= RULE_STRING ) ) ) ) ) )
            	    // InternalUcm4iot.g:962:5: {...}? => ( ({...}? => ( ruleKeywordMultiplicity otherlv_14= ':' ( (lv_multiplicity_15_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleHandlerUseCase", "getUnorderedGroupHelper().canSelect(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3(), 3)");
            	    }
            	    // InternalUcm4iot.g:962:111: ( ({...}? => ( ruleKeywordMultiplicity otherlv_14= ':' ( (lv_multiplicity_15_0= RULE_STRING ) ) ) ) )
            	    // InternalUcm4iot.g:963:6: ({...}? => ( ruleKeywordMultiplicity otherlv_14= ':' ( (lv_multiplicity_15_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3(), 3);
            	    					
            	    // InternalUcm4iot.g:966:9: ({...}? => ( ruleKeywordMultiplicity otherlv_14= ':' ( (lv_multiplicity_15_0= RULE_STRING ) ) ) )
            	    // InternalUcm4iot.g:966:10: {...}? => ( ruleKeywordMultiplicity otherlv_14= ':' ( (lv_multiplicity_15_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHandlerUseCase", "true");
            	    }
            	    // InternalUcm4iot.g:966:19: ( ruleKeywordMultiplicity otherlv_14= ':' ( (lv_multiplicity_15_0= RULE_STRING ) ) )
            	    // InternalUcm4iot.g:966:20: ruleKeywordMultiplicity otherlv_14= ':' ( (lv_multiplicity_15_0= RULE_STRING ) )
            	    {

            	    									newCompositeNode(grammarAccess.getHandlerUseCaseAccess().getKeywordMultiplicityParserRuleCall_3_3_0());
            	    								
            	    pushFollow(FOLLOW_4);
            	    ruleKeywordMultiplicity();

            	    state._fsp--;


            	    									afterParserOrEnumRuleCall();
            	    								
            	    otherlv_14=(Token)match(input,13,FOLLOW_14); 

            	    									newLeafNode(otherlv_14, grammarAccess.getHandlerUseCaseAccess().getColonKeyword_3_3_1());
            	    								
            	    // InternalUcm4iot.g:977:9: ( (lv_multiplicity_15_0= RULE_STRING ) )
            	    // InternalUcm4iot.g:978:10: (lv_multiplicity_15_0= RULE_STRING )
            	    {
            	    // InternalUcm4iot.g:978:10: (lv_multiplicity_15_0= RULE_STRING )
            	    // InternalUcm4iot.g:979:11: lv_multiplicity_15_0= RULE_STRING
            	    {
            	    lv_multiplicity_15_0=(Token)match(input,RULE_STRING,FOLLOW_20); 

            	    											newLeafNode(lv_multiplicity_15_0, grammarAccess.getHandlerUseCaseAccess().getMultiplicitySTRINGTerminalRuleCall_3_3_2_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getHandlerUseCaseRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"multiplicity",
            	    												lv_multiplicity_15_0,
            	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalUcm4iot.g:1001:4: ({...}? => ( ({...}? => ( ruleKeywordPrecondition otherlv_17= ':' ( (lv_precondition_18_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalUcm4iot.g:1001:4: ({...}? => ( ({...}? => ( ruleKeywordPrecondition otherlv_17= ':' ( (lv_precondition_18_0= RULE_STRING ) ) ) ) ) )
            	    // InternalUcm4iot.g:1002:5: {...}? => ( ({...}? => ( ruleKeywordPrecondition otherlv_17= ':' ( (lv_precondition_18_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleHandlerUseCase", "getUnorderedGroupHelper().canSelect(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3(), 4)");
            	    }
            	    // InternalUcm4iot.g:1002:111: ( ({...}? => ( ruleKeywordPrecondition otherlv_17= ':' ( (lv_precondition_18_0= RULE_STRING ) ) ) ) )
            	    // InternalUcm4iot.g:1003:6: ({...}? => ( ruleKeywordPrecondition otherlv_17= ':' ( (lv_precondition_18_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3(), 4);
            	    					
            	    // InternalUcm4iot.g:1006:9: ({...}? => ( ruleKeywordPrecondition otherlv_17= ':' ( (lv_precondition_18_0= RULE_STRING ) ) ) )
            	    // InternalUcm4iot.g:1006:10: {...}? => ( ruleKeywordPrecondition otherlv_17= ':' ( (lv_precondition_18_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHandlerUseCase", "true");
            	    }
            	    // InternalUcm4iot.g:1006:19: ( ruleKeywordPrecondition otherlv_17= ':' ( (lv_precondition_18_0= RULE_STRING ) ) )
            	    // InternalUcm4iot.g:1006:20: ruleKeywordPrecondition otherlv_17= ':' ( (lv_precondition_18_0= RULE_STRING ) )
            	    {

            	    									newCompositeNode(grammarAccess.getHandlerUseCaseAccess().getKeywordPreconditionParserRuleCall_3_4_0());
            	    								
            	    pushFollow(FOLLOW_4);
            	    ruleKeywordPrecondition();

            	    state._fsp--;


            	    									afterParserOrEnumRuleCall();
            	    								
            	    otherlv_17=(Token)match(input,13,FOLLOW_14); 

            	    									newLeafNode(otherlv_17, grammarAccess.getHandlerUseCaseAccess().getColonKeyword_3_4_1());
            	    								
            	    // InternalUcm4iot.g:1017:9: ( (lv_precondition_18_0= RULE_STRING ) )
            	    // InternalUcm4iot.g:1018:10: (lv_precondition_18_0= RULE_STRING )
            	    {
            	    // InternalUcm4iot.g:1018:10: (lv_precondition_18_0= RULE_STRING )
            	    // InternalUcm4iot.g:1019:11: lv_precondition_18_0= RULE_STRING
            	    {
            	    lv_precondition_18_0=(Token)match(input,RULE_STRING,FOLLOW_20); 

            	    											newLeafNode(lv_precondition_18_0, grammarAccess.getHandlerUseCaseAccess().getPreconditionSTRINGTerminalRuleCall_3_4_2_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getHandlerUseCaseRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"precondition",
            	    												lv_precondition_18_0,
            	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalUcm4iot.g:1041:4: ({...}? => ( ({...}? => ( ruleKeywordPostcondition otherlv_20= ':' ( (lv_postcondition_21_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalUcm4iot.g:1041:4: ({...}? => ( ({...}? => ( ruleKeywordPostcondition otherlv_20= ':' ( (lv_postcondition_21_0= RULE_STRING ) ) ) ) ) )
            	    // InternalUcm4iot.g:1042:5: {...}? => ( ({...}? => ( ruleKeywordPostcondition otherlv_20= ':' ( (lv_postcondition_21_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleHandlerUseCase", "getUnorderedGroupHelper().canSelect(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3(), 5)");
            	    }
            	    // InternalUcm4iot.g:1042:111: ( ({...}? => ( ruleKeywordPostcondition otherlv_20= ':' ( (lv_postcondition_21_0= RULE_STRING ) ) ) ) )
            	    // InternalUcm4iot.g:1043:6: ({...}? => ( ruleKeywordPostcondition otherlv_20= ':' ( (lv_postcondition_21_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3(), 5);
            	    					
            	    // InternalUcm4iot.g:1046:9: ({...}? => ( ruleKeywordPostcondition otherlv_20= ':' ( (lv_postcondition_21_0= RULE_STRING ) ) ) )
            	    // InternalUcm4iot.g:1046:10: {...}? => ( ruleKeywordPostcondition otherlv_20= ':' ( (lv_postcondition_21_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHandlerUseCase", "true");
            	    }
            	    // InternalUcm4iot.g:1046:19: ( ruleKeywordPostcondition otherlv_20= ':' ( (lv_postcondition_21_0= RULE_STRING ) ) )
            	    // InternalUcm4iot.g:1046:20: ruleKeywordPostcondition otherlv_20= ':' ( (lv_postcondition_21_0= RULE_STRING ) )
            	    {

            	    									newCompositeNode(grammarAccess.getHandlerUseCaseAccess().getKeywordPostconditionParserRuleCall_3_5_0());
            	    								
            	    pushFollow(FOLLOW_4);
            	    ruleKeywordPostcondition();

            	    state._fsp--;


            	    									afterParserOrEnumRuleCall();
            	    								
            	    otherlv_20=(Token)match(input,13,FOLLOW_14); 

            	    									newLeafNode(otherlv_20, grammarAccess.getHandlerUseCaseAccess().getColonKeyword_3_5_1());
            	    								
            	    // InternalUcm4iot.g:1057:9: ( (lv_postcondition_21_0= RULE_STRING ) )
            	    // InternalUcm4iot.g:1058:10: (lv_postcondition_21_0= RULE_STRING )
            	    {
            	    // InternalUcm4iot.g:1058:10: (lv_postcondition_21_0= RULE_STRING )
            	    // InternalUcm4iot.g:1059:11: lv_postcondition_21_0= RULE_STRING
            	    {
            	    lv_postcondition_21_0=(Token)match(input,RULE_STRING,FOLLOW_20); 

            	    											newLeafNode(lv_postcondition_21_0, grammarAccess.getHandlerUseCaseAccess().getPostconditionSTRINGTerminalRuleCall_3_5_2_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getHandlerUseCaseRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"postcondition",
            	    												lv_postcondition_21_0,
            	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // InternalUcm4iot.g:1081:4: ({...}? => ( ({...}? => ( ruleKeywordPrimaryActor otherlv_23= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) ) ) ) ) )
            	    {
            	    // InternalUcm4iot.g:1081:4: ({...}? => ( ({...}? => ( ruleKeywordPrimaryActor otherlv_23= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) ) ) ) ) )
            	    // InternalUcm4iot.g:1082:5: {...}? => ( ({...}? => ( ruleKeywordPrimaryActor otherlv_23= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleHandlerUseCase", "getUnorderedGroupHelper().canSelect(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3(), 6)");
            	    }
            	    // InternalUcm4iot.g:1082:111: ( ({...}? => ( ruleKeywordPrimaryActor otherlv_23= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) ) ) ) )
            	    // InternalUcm4iot.g:1083:6: ({...}? => ( ruleKeywordPrimaryActor otherlv_23= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3(), 6);
            	    					
            	    // InternalUcm4iot.g:1086:9: ({...}? => ( ruleKeywordPrimaryActor otherlv_23= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) ) ) )
            	    // InternalUcm4iot.g:1086:10: {...}? => ( ruleKeywordPrimaryActor otherlv_23= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHandlerUseCase", "true");
            	    }
            	    // InternalUcm4iot.g:1086:19: ( ruleKeywordPrimaryActor otherlv_23= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) ) )
            	    // InternalUcm4iot.g:1086:20: ruleKeywordPrimaryActor otherlv_23= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) )
            	    {

            	    									newCompositeNode(grammarAccess.getHandlerUseCaseAccess().getKeywordPrimaryActorParserRuleCall_3_6_0());
            	    								
            	    pushFollow(FOLLOW_4);
            	    ruleKeywordPrimaryActor();

            	    state._fsp--;


            	    									afterParserOrEnumRuleCall();
            	    								
            	    otherlv_23=(Token)match(input,13,FOLLOW_16); 

            	    									newLeafNode(otherlv_23, grammarAccess.getHandlerUseCaseAccess().getColonKeyword_3_6_1());
            	    								
            	    // InternalUcm4iot.g:1097:9: ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) )
            	    int alt16=2;
            	    int LA16_0 = input.LA(1);

            	    if ( ((LA16_0>=102 && LA16_0<=105)) ) {
            	        alt16=1;
            	    }
            	    else if ( (LA16_0==RULE_ID||(LA16_0>=27 && LA16_0<=28)) ) {
            	        alt16=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 16, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt16) {
            	        case 1 :
            	            // InternalUcm4iot.g:1098:10: ( ruleNotApplicable | ruleNone )
            	            {
            	            // InternalUcm4iot.g:1098:10: ( ruleNotApplicable | ruleNone )
            	            int alt15=2;
            	            int LA15_0 = input.LA(1);

            	            if ( ((LA15_0>=104 && LA15_0<=105)) ) {
            	                alt15=1;
            	            }
            	            else if ( ((LA15_0>=102 && LA15_0<=103)) ) {
            	                alt15=2;
            	            }
            	            else {
            	                NoViableAltException nvae =
            	                    new NoViableAltException("", 15, 0, input);

            	                throw nvae;
            	            }
            	            switch (alt15) {
            	                case 1 :
            	                    // InternalUcm4iot.g:1099:11: ruleNotApplicable
            	                    {

            	                    											newCompositeNode(grammarAccess.getHandlerUseCaseAccess().getNotApplicableParserRuleCall_3_6_2_0_0());
            	                    										
            	                    pushFollow(FOLLOW_20);
            	                    ruleNotApplicable();

            	                    state._fsp--;


            	                    											afterParserOrEnumRuleCall();
            	                    										

            	                    }
            	                    break;
            	                case 2 :
            	                    // InternalUcm4iot.g:1107:11: ruleNone
            	                    {

            	                    											newCompositeNode(grammarAccess.getHandlerUseCaseAccess().getNoneParserRuleCall_3_6_2_0_1());
            	                    										
            	                    pushFollow(FOLLOW_20);
            	                    ruleNone();

            	                    state._fsp--;


            	                    											afterParserOrEnumRuleCall();
            	                    										

            	                    }
            	                    break;

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalUcm4iot.g:1116:10: ( (lv_primaryActor_26_0= rulePrimaryActor ) )
            	            {
            	            // InternalUcm4iot.g:1116:10: ( (lv_primaryActor_26_0= rulePrimaryActor ) )
            	            // InternalUcm4iot.g:1117:11: (lv_primaryActor_26_0= rulePrimaryActor )
            	            {
            	            // InternalUcm4iot.g:1117:11: (lv_primaryActor_26_0= rulePrimaryActor )
            	            // InternalUcm4iot.g:1118:12: lv_primaryActor_26_0= rulePrimaryActor
            	            {

            	            												newCompositeNode(grammarAccess.getHandlerUseCaseAccess().getPrimaryActorPrimaryActorParserRuleCall_3_6_2_1_0());
            	            											
            	            pushFollow(FOLLOW_20);
            	            lv_primaryActor_26_0=rulePrimaryActor();

            	            state._fsp--;


            	            												if (current==null) {
            	            													current = createModelElementForParent(grammarAccess.getHandlerUseCaseRule());
            	            												}
            	            												set(
            	            													current,
            	            													"primaryActor",
            	            													lv_primaryActor_26_0,
            	            													"mde.iot.ucm4iot.Ucm4iot.PrimaryActor");
            	            												afterParserOrEnumRuleCall();
            	            											

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // InternalUcm4iot.g:1142:4: ({...}? => ( ({...}? => ( ruleKeywordSecondaryActor otherlv_28= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) ) ) ) ) )
            	    {
            	    // InternalUcm4iot.g:1142:4: ({...}? => ( ({...}? => ( ruleKeywordSecondaryActor otherlv_28= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) ) ) ) ) )
            	    // InternalUcm4iot.g:1143:5: {...}? => ( ({...}? => ( ruleKeywordSecondaryActor otherlv_28= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleHandlerUseCase", "getUnorderedGroupHelper().canSelect(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3(), 7)");
            	    }
            	    // InternalUcm4iot.g:1143:111: ( ({...}? => ( ruleKeywordSecondaryActor otherlv_28= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) ) ) ) )
            	    // InternalUcm4iot.g:1144:6: ({...}? => ( ruleKeywordSecondaryActor otherlv_28= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3(), 7);
            	    					
            	    // InternalUcm4iot.g:1147:9: ({...}? => ( ruleKeywordSecondaryActor otherlv_28= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) ) ) )
            	    // InternalUcm4iot.g:1147:10: {...}? => ( ruleKeywordSecondaryActor otherlv_28= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHandlerUseCase", "true");
            	    }
            	    // InternalUcm4iot.g:1147:19: ( ruleKeywordSecondaryActor otherlv_28= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) ) )
            	    // InternalUcm4iot.g:1147:20: ruleKeywordSecondaryActor otherlv_28= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) )
            	    {

            	    									newCompositeNode(grammarAccess.getHandlerUseCaseAccess().getKeywordSecondaryActorParserRuleCall_3_7_0());
            	    								
            	    pushFollow(FOLLOW_4);
            	    ruleKeywordSecondaryActor();

            	    state._fsp--;


            	    									afterParserOrEnumRuleCall();
            	    								
            	    otherlv_28=(Token)match(input,13,FOLLOW_17); 

            	    									newLeafNode(otherlv_28, grammarAccess.getHandlerUseCaseAccess().getColonKeyword_3_7_1());
            	    								
            	    // InternalUcm4iot.g:1158:9: ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) )
            	    int alt19=2;
            	    int LA19_0 = input.LA(1);

            	    if ( ((LA19_0>=102 && LA19_0<=105)) ) {
            	        alt19=1;
            	    }
            	    else if ( (LA19_0==RULE_ID||(LA19_0>=27 && LA19_0<=33)) ) {
            	        alt19=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 19, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt19) {
            	        case 1 :
            	            // InternalUcm4iot.g:1159:10: ( ruleNotApplicable | ruleNone )
            	            {
            	            // InternalUcm4iot.g:1159:10: ( ruleNotApplicable | ruleNone )
            	            int alt17=2;
            	            int LA17_0 = input.LA(1);

            	            if ( ((LA17_0>=104 && LA17_0<=105)) ) {
            	                alt17=1;
            	            }
            	            else if ( ((LA17_0>=102 && LA17_0<=103)) ) {
            	                alt17=2;
            	            }
            	            else {
            	                NoViableAltException nvae =
            	                    new NoViableAltException("", 17, 0, input);

            	                throw nvae;
            	            }
            	            switch (alt17) {
            	                case 1 :
            	                    // InternalUcm4iot.g:1160:11: ruleNotApplicable
            	                    {

            	                    											newCompositeNode(grammarAccess.getHandlerUseCaseAccess().getNotApplicableParserRuleCall_3_7_2_0_0());
            	                    										
            	                    pushFollow(FOLLOW_20);
            	                    ruleNotApplicable();

            	                    state._fsp--;


            	                    											afterParserOrEnumRuleCall();
            	                    										

            	                    }
            	                    break;
            	                case 2 :
            	                    // InternalUcm4iot.g:1168:11: ruleNone
            	                    {

            	                    											newCompositeNode(grammarAccess.getHandlerUseCaseAccess().getNoneParserRuleCall_3_7_2_0_1());
            	                    										
            	                    pushFollow(FOLLOW_20);
            	                    ruleNone();

            	                    state._fsp--;


            	                    											afterParserOrEnumRuleCall();
            	                    										

            	                    }
            	                    break;

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalUcm4iot.g:1177:10: ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* )
            	            {
            	            // InternalUcm4iot.g:1177:10: ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* )
            	            // InternalUcm4iot.g:1178:11: ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )*
            	            {
            	            // InternalUcm4iot.g:1178:11: ( (lv_secondaryActors_31_0= ruleSecondaryActor ) )
            	            // InternalUcm4iot.g:1179:12: (lv_secondaryActors_31_0= ruleSecondaryActor )
            	            {
            	            // InternalUcm4iot.g:1179:12: (lv_secondaryActors_31_0= ruleSecondaryActor )
            	            // InternalUcm4iot.g:1180:13: lv_secondaryActors_31_0= ruleSecondaryActor
            	            {

            	            													newCompositeNode(grammarAccess.getHandlerUseCaseAccess().getSecondaryActorsSecondaryActorParserRuleCall_3_7_2_1_0_0());
            	            												
            	            pushFollow(FOLLOW_21);
            	            lv_secondaryActors_31_0=ruleSecondaryActor();

            	            state._fsp--;


            	            													if (current==null) {
            	            														current = createModelElementForParent(grammarAccess.getHandlerUseCaseRule());
            	            													}
            	            													add(
            	            														current,
            	            														"secondaryActors",
            	            														lv_secondaryActors_31_0,
            	            														"mde.iot.ucm4iot.Ucm4iot.SecondaryActor");
            	            													afterParserOrEnumRuleCall();
            	            												

            	            }


            	            }

            	            // InternalUcm4iot.g:1197:11: (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )*
            	            loop18:
            	            do {
            	                int alt18=2;
            	                int LA18_0 = input.LA(1);

            	                if ( (LA18_0==16) ) {
            	                    alt18=1;
            	                }


            	                switch (alt18) {
            	            	case 1 :
            	            	    // InternalUcm4iot.g:1198:12: otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) )
            	            	    {
            	            	    otherlv_32=(Token)match(input,16,FOLLOW_17); 

            	            	    												newLeafNode(otherlv_32, grammarAccess.getHandlerUseCaseAccess().getCommaKeyword_3_7_2_1_1_0());
            	            	    											
            	            	    // InternalUcm4iot.g:1202:12: ( (lv_secondaryActors_33_0= ruleSecondaryActor ) )
            	            	    // InternalUcm4iot.g:1203:13: (lv_secondaryActors_33_0= ruleSecondaryActor )
            	            	    {
            	            	    // InternalUcm4iot.g:1203:13: (lv_secondaryActors_33_0= ruleSecondaryActor )
            	            	    // InternalUcm4iot.g:1204:14: lv_secondaryActors_33_0= ruleSecondaryActor
            	            	    {

            	            	    														newCompositeNode(grammarAccess.getHandlerUseCaseAccess().getSecondaryActorsSecondaryActorParserRuleCall_3_7_2_1_1_1_0());
            	            	    													
            	            	    pushFollow(FOLLOW_21);
            	            	    lv_secondaryActors_33_0=ruleSecondaryActor();

            	            	    state._fsp--;


            	            	    														if (current==null) {
            	            	    															current = createModelElementForParent(grammarAccess.getHandlerUseCaseRule());
            	            	    														}
            	            	    														add(
            	            	    															current,
            	            	    															"secondaryActors",
            	            	    															lv_secondaryActors_33_0,
            	            	    															"mde.iot.ucm4iot.Ucm4iot.SecondaryActor");
            	            	    														afterParserOrEnumRuleCall();
            	            	    													

            	            	    }


            	            	    }


            	            	    }
            	            	    break;

            	            	default :
            	            	    break loop18;
            	                }
            	            } while (true);


            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 9 :
            	    // InternalUcm4iot.g:1230:4: ({...}? => ( ({...}? => ( ruleKeywordFacilitatorActor otherlv_35= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) ) ) ) ) )
            	    {
            	    // InternalUcm4iot.g:1230:4: ({...}? => ( ({...}? => ( ruleKeywordFacilitatorActor otherlv_35= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) ) ) ) ) )
            	    // InternalUcm4iot.g:1231:5: {...}? => ( ({...}? => ( ruleKeywordFacilitatorActor otherlv_35= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3(), 8) ) {
            	        throw new FailedPredicateException(input, "ruleHandlerUseCase", "getUnorderedGroupHelper().canSelect(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3(), 8)");
            	    }
            	    // InternalUcm4iot.g:1231:111: ( ({...}? => ( ruleKeywordFacilitatorActor otherlv_35= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) ) ) ) )
            	    // InternalUcm4iot.g:1232:6: ({...}? => ( ruleKeywordFacilitatorActor otherlv_35= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3(), 8);
            	    					
            	    // InternalUcm4iot.g:1235:9: ({...}? => ( ruleKeywordFacilitatorActor otherlv_35= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) ) ) )
            	    // InternalUcm4iot.g:1235:10: {...}? => ( ruleKeywordFacilitatorActor otherlv_35= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHandlerUseCase", "true");
            	    }
            	    // InternalUcm4iot.g:1235:19: ( ruleKeywordFacilitatorActor otherlv_35= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) ) )
            	    // InternalUcm4iot.g:1235:20: ruleKeywordFacilitatorActor otherlv_35= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) )
            	    {

            	    									newCompositeNode(grammarAccess.getHandlerUseCaseAccess().getKeywordFacilitatorActorParserRuleCall_3_8_0());
            	    								
            	    pushFollow(FOLLOW_4);
            	    ruleKeywordFacilitatorActor();

            	    state._fsp--;


            	    									afterParserOrEnumRuleCall();
            	    								
            	    otherlv_35=(Token)match(input,13,FOLLOW_17); 

            	    									newLeafNode(otherlv_35, grammarAccess.getHandlerUseCaseAccess().getColonKeyword_3_8_1());
            	    								
            	    // InternalUcm4iot.g:1246:9: ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) )
            	    int alt22=2;
            	    int LA22_0 = input.LA(1);

            	    if ( ((LA22_0>=102 && LA22_0<=105)) ) {
            	        alt22=1;
            	    }
            	    else if ( (LA22_0==RULE_ID||(LA22_0>=27 && LA22_0<=33)) ) {
            	        alt22=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 22, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt22) {
            	        case 1 :
            	            // InternalUcm4iot.g:1247:10: ( ruleNotApplicable | ruleNone )
            	            {
            	            // InternalUcm4iot.g:1247:10: ( ruleNotApplicable | ruleNone )
            	            int alt20=2;
            	            int LA20_0 = input.LA(1);

            	            if ( ((LA20_0>=104 && LA20_0<=105)) ) {
            	                alt20=1;
            	            }
            	            else if ( ((LA20_0>=102 && LA20_0<=103)) ) {
            	                alt20=2;
            	            }
            	            else {
            	                NoViableAltException nvae =
            	                    new NoViableAltException("", 20, 0, input);

            	                throw nvae;
            	            }
            	            switch (alt20) {
            	                case 1 :
            	                    // InternalUcm4iot.g:1248:11: ruleNotApplicable
            	                    {

            	                    											newCompositeNode(grammarAccess.getHandlerUseCaseAccess().getNotApplicableParserRuleCall_3_8_2_0_0());
            	                    										
            	                    pushFollow(FOLLOW_20);
            	                    ruleNotApplicable();

            	                    state._fsp--;


            	                    											afterParserOrEnumRuleCall();
            	                    										

            	                    }
            	                    break;
            	                case 2 :
            	                    // InternalUcm4iot.g:1256:11: ruleNone
            	                    {

            	                    											newCompositeNode(grammarAccess.getHandlerUseCaseAccess().getNoneParserRuleCall_3_8_2_0_1());
            	                    										
            	                    pushFollow(FOLLOW_20);
            	                    ruleNone();

            	                    state._fsp--;


            	                    											afterParserOrEnumRuleCall();
            	                    										

            	                    }
            	                    break;

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalUcm4iot.g:1265:10: ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* )
            	            {
            	            // InternalUcm4iot.g:1265:10: ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* )
            	            // InternalUcm4iot.g:1266:11: ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )*
            	            {
            	            // InternalUcm4iot.g:1266:11: ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) )
            	            // InternalUcm4iot.g:1267:12: (lv_facilitatorActors_38_0= ruleSecondaryActor )
            	            {
            	            // InternalUcm4iot.g:1267:12: (lv_facilitatorActors_38_0= ruleSecondaryActor )
            	            // InternalUcm4iot.g:1268:13: lv_facilitatorActors_38_0= ruleSecondaryActor
            	            {

            	            													newCompositeNode(grammarAccess.getHandlerUseCaseAccess().getFacilitatorActorsSecondaryActorParserRuleCall_3_8_2_1_0_0());
            	            												
            	            pushFollow(FOLLOW_21);
            	            lv_facilitatorActors_38_0=ruleSecondaryActor();

            	            state._fsp--;


            	            													if (current==null) {
            	            														current = createModelElementForParent(grammarAccess.getHandlerUseCaseRule());
            	            													}
            	            													add(
            	            														current,
            	            														"facilitatorActors",
            	            														lv_facilitatorActors_38_0,
            	            														"mde.iot.ucm4iot.Ucm4iot.SecondaryActor");
            	            													afterParserOrEnumRuleCall();
            	            												

            	            }


            	            }

            	            // InternalUcm4iot.g:1285:11: (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )*
            	            loop21:
            	            do {
            	                int alt21=2;
            	                int LA21_0 = input.LA(1);

            	                if ( (LA21_0==16) ) {
            	                    alt21=1;
            	                }


            	                switch (alt21) {
            	            	case 1 :
            	            	    // InternalUcm4iot.g:1286:12: otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) )
            	            	    {
            	            	    otherlv_39=(Token)match(input,16,FOLLOW_17); 

            	            	    												newLeafNode(otherlv_39, grammarAccess.getHandlerUseCaseAccess().getCommaKeyword_3_8_2_1_1_0());
            	            	    											
            	            	    // InternalUcm4iot.g:1290:12: ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) )
            	            	    // InternalUcm4iot.g:1291:13: (lv_facilitatorActors_40_0= ruleSecondaryActor )
            	            	    {
            	            	    // InternalUcm4iot.g:1291:13: (lv_facilitatorActors_40_0= ruleSecondaryActor )
            	            	    // InternalUcm4iot.g:1292:14: lv_facilitatorActors_40_0= ruleSecondaryActor
            	            	    {

            	            	    														newCompositeNode(grammarAccess.getHandlerUseCaseAccess().getFacilitatorActorsSecondaryActorParserRuleCall_3_8_2_1_1_1_0());
            	            	    													
            	            	    pushFollow(FOLLOW_21);
            	            	    lv_facilitatorActors_40_0=ruleSecondaryActor();

            	            	    state._fsp--;


            	            	    														if (current==null) {
            	            	    															current = createModelElementForParent(grammarAccess.getHandlerUseCaseRule());
            	            	    														}
            	            	    														add(
            	            	    															current,
            	            	    															"facilitatorActors",
            	            	    															lv_facilitatorActors_40_0,
            	            	    															"mde.iot.ucm4iot.Ucm4iot.SecondaryActor");
            	            	    														afterParserOrEnumRuleCall();
            	            	    													

            	            	    }


            	            	    }


            	            	    }
            	            	    break;

            	            	default :
            	            	    break loop21;
            	                }
            	            } while (true);


            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 10 :
            	    // InternalUcm4iot.g:1318:4: ({...}? => ( ({...}? => ( ruleKeywordHandlerClass otherlv_42= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_handlerClass_45_0= RULE_ID ) ) ) ) ) ) )
            	    {
            	    // InternalUcm4iot.g:1318:4: ({...}? => ( ({...}? => ( ruleKeywordHandlerClass otherlv_42= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_handlerClass_45_0= RULE_ID ) ) ) ) ) ) )
            	    // InternalUcm4iot.g:1319:5: {...}? => ( ({...}? => ( ruleKeywordHandlerClass otherlv_42= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_handlerClass_45_0= RULE_ID ) ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3(), 9) ) {
            	        throw new FailedPredicateException(input, "ruleHandlerUseCase", "getUnorderedGroupHelper().canSelect(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3(), 9)");
            	    }
            	    // InternalUcm4iot.g:1319:111: ( ({...}? => ( ruleKeywordHandlerClass otherlv_42= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_handlerClass_45_0= RULE_ID ) ) ) ) ) )
            	    // InternalUcm4iot.g:1320:6: ({...}? => ( ruleKeywordHandlerClass otherlv_42= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_handlerClass_45_0= RULE_ID ) ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3(), 9);
            	    					
            	    // InternalUcm4iot.g:1323:9: ({...}? => ( ruleKeywordHandlerClass otherlv_42= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_handlerClass_45_0= RULE_ID ) ) ) ) )
            	    // InternalUcm4iot.g:1323:10: {...}? => ( ruleKeywordHandlerClass otherlv_42= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_handlerClass_45_0= RULE_ID ) ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHandlerUseCase", "true");
            	    }
            	    // InternalUcm4iot.g:1323:19: ( ruleKeywordHandlerClass otherlv_42= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_handlerClass_45_0= RULE_ID ) ) ) )
            	    // InternalUcm4iot.g:1323:20: ruleKeywordHandlerClass otherlv_42= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_handlerClass_45_0= RULE_ID ) ) )
            	    {

            	    									newCompositeNode(grammarAccess.getHandlerUseCaseAccess().getKeywordHandlerClassParserRuleCall_3_9_0());
            	    								
            	    pushFollow(FOLLOW_4);
            	    ruleKeywordHandlerClass();

            	    state._fsp--;


            	    									afterParserOrEnumRuleCall();
            	    								
            	    otherlv_42=(Token)match(input,13,FOLLOW_22); 

            	    									newLeafNode(otherlv_42, grammarAccess.getHandlerUseCaseAccess().getColonKeyword_3_9_1());
            	    								
            	    // InternalUcm4iot.g:1334:9: ( ( ruleNotApplicable | ruleNone ) | ( (lv_handlerClass_45_0= RULE_ID ) ) )
            	    int alt24=2;
            	    int LA24_0 = input.LA(1);

            	    if ( ((LA24_0>=102 && LA24_0<=105)) ) {
            	        alt24=1;
            	    }
            	    else if ( (LA24_0==RULE_ID) ) {
            	        alt24=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 24, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt24) {
            	        case 1 :
            	            // InternalUcm4iot.g:1335:10: ( ruleNotApplicable | ruleNone )
            	            {
            	            // InternalUcm4iot.g:1335:10: ( ruleNotApplicable | ruleNone )
            	            int alt23=2;
            	            int LA23_0 = input.LA(1);

            	            if ( ((LA23_0>=104 && LA23_0<=105)) ) {
            	                alt23=1;
            	            }
            	            else if ( ((LA23_0>=102 && LA23_0<=103)) ) {
            	                alt23=2;
            	            }
            	            else {
            	                NoViableAltException nvae =
            	                    new NoViableAltException("", 23, 0, input);

            	                throw nvae;
            	            }
            	            switch (alt23) {
            	                case 1 :
            	                    // InternalUcm4iot.g:1336:11: ruleNotApplicable
            	                    {

            	                    											newCompositeNode(grammarAccess.getHandlerUseCaseAccess().getNotApplicableParserRuleCall_3_9_2_0_0());
            	                    										
            	                    pushFollow(FOLLOW_20);
            	                    ruleNotApplicable();

            	                    state._fsp--;


            	                    											afterParserOrEnumRuleCall();
            	                    										

            	                    }
            	                    break;
            	                case 2 :
            	                    // InternalUcm4iot.g:1344:11: ruleNone
            	                    {

            	                    											newCompositeNode(grammarAccess.getHandlerUseCaseAccess().getNoneParserRuleCall_3_9_2_0_1());
            	                    										
            	                    pushFollow(FOLLOW_20);
            	                    ruleNone();

            	                    state._fsp--;


            	                    											afterParserOrEnumRuleCall();
            	                    										

            	                    }
            	                    break;

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalUcm4iot.g:1353:10: ( (lv_handlerClass_45_0= RULE_ID ) )
            	            {
            	            // InternalUcm4iot.g:1353:10: ( (lv_handlerClass_45_0= RULE_ID ) )
            	            // InternalUcm4iot.g:1354:11: (lv_handlerClass_45_0= RULE_ID )
            	            {
            	            // InternalUcm4iot.g:1354:11: (lv_handlerClass_45_0= RULE_ID )
            	            // InternalUcm4iot.g:1355:12: lv_handlerClass_45_0= RULE_ID
            	            {
            	            lv_handlerClass_45_0=(Token)match(input,RULE_ID,FOLLOW_20); 

            	            												newLeafNode(lv_handlerClass_45_0, grammarAccess.getHandlerUseCaseAccess().getHandlerClassIDTerminalRuleCall_3_9_2_1_0());
            	            											

            	            												if (current==null) {
            	            													current = createModelElement(grammarAccess.getHandlerUseCaseRule());
            	            												}
            	            												setWithLastConsumed(
            	            													current,
            	            													"handlerClass",
            	            													lv_handlerClass_45_0,
            	            													"org.eclipse.xtext.common.Terminals.ID");
            	            											

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 11 :
            	    // InternalUcm4iot.g:1378:4: ({...}? => ( ({...}? => ( ruleKeywordContextException otherlv_47= ':' ( (lv_contextExceptions_48_0= ruleContextExceptionMapping ) ) (otherlv_49= ',' ( (lv_contextExceptions_50_0= ruleContextExceptionMapping ) ) )* ) ) ) )
            	    {
            	    // InternalUcm4iot.g:1378:4: ({...}? => ( ({...}? => ( ruleKeywordContextException otherlv_47= ':' ( (lv_contextExceptions_48_0= ruleContextExceptionMapping ) ) (otherlv_49= ',' ( (lv_contextExceptions_50_0= ruleContextExceptionMapping ) ) )* ) ) ) )
            	    // InternalUcm4iot.g:1379:5: {...}? => ( ({...}? => ( ruleKeywordContextException otherlv_47= ':' ( (lv_contextExceptions_48_0= ruleContextExceptionMapping ) ) (otherlv_49= ',' ( (lv_contextExceptions_50_0= ruleContextExceptionMapping ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3(), 10) ) {
            	        throw new FailedPredicateException(input, "ruleHandlerUseCase", "getUnorderedGroupHelper().canSelect(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3(), 10)");
            	    }
            	    // InternalUcm4iot.g:1379:112: ( ({...}? => ( ruleKeywordContextException otherlv_47= ':' ( (lv_contextExceptions_48_0= ruleContextExceptionMapping ) ) (otherlv_49= ',' ( (lv_contextExceptions_50_0= ruleContextExceptionMapping ) ) )* ) ) )
            	    // InternalUcm4iot.g:1380:6: ({...}? => ( ruleKeywordContextException otherlv_47= ':' ( (lv_contextExceptions_48_0= ruleContextExceptionMapping ) ) (otherlv_49= ',' ( (lv_contextExceptions_50_0= ruleContextExceptionMapping ) ) )* ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3(), 10);
            	    					
            	    // InternalUcm4iot.g:1383:9: ({...}? => ( ruleKeywordContextException otherlv_47= ':' ( (lv_contextExceptions_48_0= ruleContextExceptionMapping ) ) (otherlv_49= ',' ( (lv_contextExceptions_50_0= ruleContextExceptionMapping ) ) )* ) )
            	    // InternalUcm4iot.g:1383:10: {...}? => ( ruleKeywordContextException otherlv_47= ':' ( (lv_contextExceptions_48_0= ruleContextExceptionMapping ) ) (otherlv_49= ',' ( (lv_contextExceptions_50_0= ruleContextExceptionMapping ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHandlerUseCase", "true");
            	    }
            	    // InternalUcm4iot.g:1383:19: ( ruleKeywordContextException otherlv_47= ':' ( (lv_contextExceptions_48_0= ruleContextExceptionMapping ) ) (otherlv_49= ',' ( (lv_contextExceptions_50_0= ruleContextExceptionMapping ) ) )* )
            	    // InternalUcm4iot.g:1383:20: ruleKeywordContextException otherlv_47= ':' ( (lv_contextExceptions_48_0= ruleContextExceptionMapping ) ) (otherlv_49= ',' ( (lv_contextExceptions_50_0= ruleContextExceptionMapping ) ) )*
            	    {

            	    									newCompositeNode(grammarAccess.getHandlerUseCaseAccess().getKeywordContextExceptionParserRuleCall_3_10_0());
            	    								
            	    pushFollow(FOLLOW_4);
            	    ruleKeywordContextException();

            	    state._fsp--;


            	    									afterParserOrEnumRuleCall();
            	    								
            	    otherlv_47=(Token)match(input,13,FOLLOW_11); 

            	    									newLeafNode(otherlv_47, grammarAccess.getHandlerUseCaseAccess().getColonKeyword_3_10_1());
            	    								
            	    // InternalUcm4iot.g:1394:9: ( (lv_contextExceptions_48_0= ruleContextExceptionMapping ) )
            	    // InternalUcm4iot.g:1395:10: (lv_contextExceptions_48_0= ruleContextExceptionMapping )
            	    {
            	    // InternalUcm4iot.g:1395:10: (lv_contextExceptions_48_0= ruleContextExceptionMapping )
            	    // InternalUcm4iot.g:1396:11: lv_contextExceptions_48_0= ruleContextExceptionMapping
            	    {

            	    											newCompositeNode(grammarAccess.getHandlerUseCaseAccess().getContextExceptionsContextExceptionMappingParserRuleCall_3_10_2_0());
            	    										
            	    pushFollow(FOLLOW_21);
            	    lv_contextExceptions_48_0=ruleContextExceptionMapping();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getHandlerUseCaseRule());
            	    											}
            	    											add(
            	    												current,
            	    												"contextExceptions",
            	    												lv_contextExceptions_48_0,
            	    												"mde.iot.ucm4iot.Ucm4iot.ContextExceptionMapping");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }

            	    // InternalUcm4iot.g:1413:9: (otherlv_49= ',' ( (lv_contextExceptions_50_0= ruleContextExceptionMapping ) ) )*
            	    loop25:
            	    do {
            	        int alt25=2;
            	        int LA25_0 = input.LA(1);

            	        if ( (LA25_0==16) ) {
            	            alt25=1;
            	        }


            	        switch (alt25) {
            	    	case 1 :
            	    	    // InternalUcm4iot.g:1414:10: otherlv_49= ',' ( (lv_contextExceptions_50_0= ruleContextExceptionMapping ) )
            	    	    {
            	    	    otherlv_49=(Token)match(input,16,FOLLOW_11); 

            	    	    										newLeafNode(otherlv_49, grammarAccess.getHandlerUseCaseAccess().getCommaKeyword_3_10_3_0());
            	    	    									
            	    	    // InternalUcm4iot.g:1418:10: ( (lv_contextExceptions_50_0= ruleContextExceptionMapping ) )
            	    	    // InternalUcm4iot.g:1419:11: (lv_contextExceptions_50_0= ruleContextExceptionMapping )
            	    	    {
            	    	    // InternalUcm4iot.g:1419:11: (lv_contextExceptions_50_0= ruleContextExceptionMapping )
            	    	    // InternalUcm4iot.g:1420:12: lv_contextExceptions_50_0= ruleContextExceptionMapping
            	    	    {

            	    	    												newCompositeNode(grammarAccess.getHandlerUseCaseAccess().getContextExceptionsContextExceptionMappingParserRuleCall_3_10_3_1_0());
            	    	    											
            	    	    pushFollow(FOLLOW_21);
            	    	    lv_contextExceptions_50_0=ruleContextExceptionMapping();

            	    	    state._fsp--;


            	    	    												if (current==null) {
            	    	    													current = createModelElementForParent(grammarAccess.getHandlerUseCaseRule());
            	    	    												}
            	    	    												add(
            	    	    													current,
            	    	    													"contextExceptions",
            	    	    													lv_contextExceptions_50_0,
            	    	    													"mde.iot.ucm4iot.Ucm4iot.ContextExceptionMapping");
            	    	    												afterParserOrEnumRuleCall();
            	    	    											

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop25;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt26 >= 1 ) break loop26;
                        EarlyExitException eee =
                            new EarlyExitException(26, input);
                        throw eee;
                }
                cnt26++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3()) ) {
                throw new FailedPredicateException(input, "ruleHandlerUseCase", "getUnorderedGroupHelper().canLeave(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3())");
            }

            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3());
            				

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHandlerUseCase"


    // $ANTLR start "entryRuleMainScenario"
    // InternalUcm4iot.g:1456:1: entryRuleMainScenario returns [EObject current=null] : iv_ruleMainScenario= ruleMainScenario EOF ;
    public final EObject entryRuleMainScenario() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMainScenario = null;


        try {
            // InternalUcm4iot.g:1456:53: (iv_ruleMainScenario= ruleMainScenario EOF )
            // InternalUcm4iot.g:1457:2: iv_ruleMainScenario= ruleMainScenario EOF
            {
             newCompositeNode(grammarAccess.getMainScenarioRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMainScenario=ruleMainScenario();

            state._fsp--;

             current =iv_ruleMainScenario; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMainScenario"


    // $ANTLR start "ruleMainScenario"
    // InternalUcm4iot.g:1463:1: ruleMainScenario returns [EObject current=null] : ( ( (lv_steps_0_0= ruleStep ) )+ ( (lv_outcome_1_0= ruleOutcomeEnds ) ) ) ;
    public final EObject ruleMainScenario() throws RecognitionException {
        EObject current = null;

        EObject lv_steps_0_0 = null;

        EObject lv_outcome_1_0 = null;



        	enterRule();

        try {
            // InternalUcm4iot.g:1469:2: ( ( ( (lv_steps_0_0= ruleStep ) )+ ( (lv_outcome_1_0= ruleOutcomeEnds ) ) ) )
            // InternalUcm4iot.g:1470:2: ( ( (lv_steps_0_0= ruleStep ) )+ ( (lv_outcome_1_0= ruleOutcomeEnds ) ) )
            {
            // InternalUcm4iot.g:1470:2: ( ( (lv_steps_0_0= ruleStep ) )+ ( (lv_outcome_1_0= ruleOutcomeEnds ) ) )
            // InternalUcm4iot.g:1471:3: ( (lv_steps_0_0= ruleStep ) )+ ( (lv_outcome_1_0= ruleOutcomeEnds ) )
            {
            // InternalUcm4iot.g:1471:3: ( (lv_steps_0_0= ruleStep ) )+
            int cnt27=0;
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>=RULE_STRING && LA27_0<=RULE_INT)||LA27_0==18) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalUcm4iot.g:1472:4: (lv_steps_0_0= ruleStep )
            	    {
            	    // InternalUcm4iot.g:1472:4: (lv_steps_0_0= ruleStep )
            	    // InternalUcm4iot.g:1473:5: lv_steps_0_0= ruleStep
            	    {

            	    					newCompositeNode(grammarAccess.getMainScenarioAccess().getStepsStepParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_23);
            	    lv_steps_0_0=ruleStep();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getMainScenarioRule());
            	    					}
            	    					add(
            	    						current,
            	    						"steps",
            	    						lv_steps_0_0,
            	    						"mde.iot.ucm4iot.Ucm4iot.Step");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt27 >= 1 ) break loop27;
                        EarlyExitException eee =
                            new EarlyExitException(27, input);
                        throw eee;
                }
                cnt27++;
            } while (true);

            // InternalUcm4iot.g:1490:3: ( (lv_outcome_1_0= ruleOutcomeEnds ) )
            // InternalUcm4iot.g:1491:4: (lv_outcome_1_0= ruleOutcomeEnds )
            {
            // InternalUcm4iot.g:1491:4: (lv_outcome_1_0= ruleOutcomeEnds )
            // InternalUcm4iot.g:1492:5: lv_outcome_1_0= ruleOutcomeEnds
            {

            					newCompositeNode(grammarAccess.getMainScenarioAccess().getOutcomeOutcomeEndsParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_outcome_1_0=ruleOutcomeEnds();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMainScenarioRule());
            					}
            					set(
            						current,
            						"outcome",
            						lv_outcome_1_0,
            						"mde.iot.ucm4iot.Ucm4iot.OutcomeEnds");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMainScenario"


    // $ANTLR start "entryRuleExtensions"
    // InternalUcm4iot.g:1513:1: entryRuleExtensions returns [EObject current=null] : iv_ruleExtensions= ruleExtensions EOF ;
    public final EObject entryRuleExtensions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensions = null;


        try {
            // InternalUcm4iot.g:1513:51: (iv_ruleExtensions= ruleExtensions EOF )
            // InternalUcm4iot.g:1514:2: iv_ruleExtensions= ruleExtensions EOF
            {
             newCompositeNode(grammarAccess.getExtensionsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExtensions=ruleExtensions();

            state._fsp--;

             current =iv_ruleExtensions; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExtensions"


    // $ANTLR start "ruleExtensions"
    // InternalUcm4iot.g:1520:1: ruleExtensions returns [EObject current=null] : ( (lv_blocks_0_0= ruleExtensionBlock ) )+ ;
    public final EObject ruleExtensions() throws RecognitionException {
        EObject current = null;

        EObject lv_blocks_0_0 = null;



        	enterRule();

        try {
            // InternalUcm4iot.g:1526:2: ( ( (lv_blocks_0_0= ruleExtensionBlock ) )+ )
            // InternalUcm4iot.g:1527:2: ( (lv_blocks_0_0= ruleExtensionBlock ) )+
            {
            // InternalUcm4iot.g:1527:2: ( (lv_blocks_0_0= ruleExtensionBlock ) )+
            int cnt28=0;
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( ((LA28_0>=72 && LA28_0<=75)) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalUcm4iot.g:1528:3: (lv_blocks_0_0= ruleExtensionBlock )
            	    {
            	    // InternalUcm4iot.g:1528:3: (lv_blocks_0_0= ruleExtensionBlock )
            	    // InternalUcm4iot.g:1529:4: lv_blocks_0_0= ruleExtensionBlock
            	    {

            	    				newCompositeNode(grammarAccess.getExtensionsAccess().getBlocksExtensionBlockParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_24);
            	    lv_blocks_0_0=ruleExtensionBlock();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getExtensionsRule());
            	    				}
            	    				add(
            	    					current,
            	    					"blocks",
            	    					lv_blocks_0_0,
            	    					"mde.iot.ucm4iot.Ucm4iot.ExtensionBlock");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt28 >= 1 ) break loop28;
                        EarlyExitException eee =
                            new EarlyExitException(28, input);
                        throw eee;
                }
                cnt28++;
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExtensions"


    // $ANTLR start "entryRuleExtensionBlock"
    // InternalUcm4iot.g:1549:1: entryRuleExtensionBlock returns [EObject current=null] : iv_ruleExtensionBlock= ruleExtensionBlock EOF ;
    public final EObject entryRuleExtensionBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionBlock = null;


        try {
            // InternalUcm4iot.g:1549:55: (iv_ruleExtensionBlock= ruleExtensionBlock EOF )
            // InternalUcm4iot.g:1550:2: iv_ruleExtensionBlock= ruleExtensionBlock EOF
            {
             newCompositeNode(grammarAccess.getExtensionBlockRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExtensionBlock=ruleExtensionBlock();

            state._fsp--;

             current =iv_ruleExtensionBlock; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExtensionBlock"


    // $ANTLR start "ruleExtensionBlock"
    // InternalUcm4iot.g:1556:1: ruleExtensionBlock returns [EObject current=null] : (this_AlternateBlock_0= ruleAlternateBlock | this_ExceptionalBlock_1= ruleExceptionalBlock ) ;
    public final EObject ruleExtensionBlock() throws RecognitionException {
        EObject current = null;

        EObject this_AlternateBlock_0 = null;

        EObject this_ExceptionalBlock_1 = null;



        	enterRule();

        try {
            // InternalUcm4iot.g:1562:2: ( (this_AlternateBlock_0= ruleAlternateBlock | this_ExceptionalBlock_1= ruleExceptionalBlock ) )
            // InternalUcm4iot.g:1563:2: (this_AlternateBlock_0= ruleAlternateBlock | this_ExceptionalBlock_1= ruleExceptionalBlock )
            {
            // InternalUcm4iot.g:1563:2: (this_AlternateBlock_0= ruleAlternateBlock | this_ExceptionalBlock_1= ruleExceptionalBlock )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=72 && LA29_0<=73)) ) {
                alt29=1;
            }
            else if ( ((LA29_0>=74 && LA29_0<=75)) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // InternalUcm4iot.g:1564:3: this_AlternateBlock_0= ruleAlternateBlock
                    {

                    			newCompositeNode(grammarAccess.getExtensionBlockAccess().getAlternateBlockParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_AlternateBlock_0=ruleAlternateBlock();

                    state._fsp--;


                    			current = this_AlternateBlock_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:1573:3: this_ExceptionalBlock_1= ruleExceptionalBlock
                    {

                    			newCompositeNode(grammarAccess.getExtensionBlockAccess().getExceptionalBlockParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ExceptionalBlock_1=ruleExceptionalBlock();

                    state._fsp--;


                    			current = this_ExceptionalBlock_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExtensionBlock"


    // $ANTLR start "entryRuleAlternateBlock"
    // InternalUcm4iot.g:1585:1: entryRuleAlternateBlock returns [EObject current=null] : iv_ruleAlternateBlock= ruleAlternateBlock EOF ;
    public final EObject entryRuleAlternateBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternateBlock = null;


        try {
            // InternalUcm4iot.g:1585:55: (iv_ruleAlternateBlock= ruleAlternateBlock EOF )
            // InternalUcm4iot.g:1586:2: iv_ruleAlternateBlock= ruleAlternateBlock EOF
            {
             newCompositeNode(grammarAccess.getAlternateBlockRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAlternateBlock=ruleAlternateBlock();

            state._fsp--;

             current =iv_ruleAlternateBlock; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAlternateBlock"


    // $ANTLR start "ruleAlternateBlock"
    // InternalUcm4iot.g:1592:1: ruleAlternateBlock returns [EObject current=null] : ( ruleKeywordAlternateBlock otherlv_1= 'for' ( ( ( ruleStepNumber ) ) | ( ( (lv_hasRangedRef_3_0= '(' ) ) ( ( ruleStepNumber ) ) otherlv_5= '-' ( ( ruleStepNumber ) ) otherlv_7= ')' ) ) otherlv_8= ':' ( (lv_steps_9_0= ruleStep ) )+ ( ( (lv_outcome_10_0= ruleOutcome ) ) | ( ruleKeywordChildListBegins otherlv_12= ':' ( (lv_blocks_13_0= ruleExtensionBlock ) )+ ruleKeywordChildListEnds ) ) ) ;
    public final EObject ruleAlternateBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_hasRangedRef_3_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_12=null;
        EObject lv_steps_9_0 = null;

        EObject lv_outcome_10_0 = null;

        EObject lv_blocks_13_0 = null;



        	enterRule();

        try {
            // InternalUcm4iot.g:1598:2: ( ( ruleKeywordAlternateBlock otherlv_1= 'for' ( ( ( ruleStepNumber ) ) | ( ( (lv_hasRangedRef_3_0= '(' ) ) ( ( ruleStepNumber ) ) otherlv_5= '-' ( ( ruleStepNumber ) ) otherlv_7= ')' ) ) otherlv_8= ':' ( (lv_steps_9_0= ruleStep ) )+ ( ( (lv_outcome_10_0= ruleOutcome ) ) | ( ruleKeywordChildListBegins otherlv_12= ':' ( (lv_blocks_13_0= ruleExtensionBlock ) )+ ruleKeywordChildListEnds ) ) ) )
            // InternalUcm4iot.g:1599:2: ( ruleKeywordAlternateBlock otherlv_1= 'for' ( ( ( ruleStepNumber ) ) | ( ( (lv_hasRangedRef_3_0= '(' ) ) ( ( ruleStepNumber ) ) otherlv_5= '-' ( ( ruleStepNumber ) ) otherlv_7= ')' ) ) otherlv_8= ':' ( (lv_steps_9_0= ruleStep ) )+ ( ( (lv_outcome_10_0= ruleOutcome ) ) | ( ruleKeywordChildListBegins otherlv_12= ':' ( (lv_blocks_13_0= ruleExtensionBlock ) )+ ruleKeywordChildListEnds ) ) )
            {
            // InternalUcm4iot.g:1599:2: ( ruleKeywordAlternateBlock otherlv_1= 'for' ( ( ( ruleStepNumber ) ) | ( ( (lv_hasRangedRef_3_0= '(' ) ) ( ( ruleStepNumber ) ) otherlv_5= '-' ( ( ruleStepNumber ) ) otherlv_7= ')' ) ) otherlv_8= ':' ( (lv_steps_9_0= ruleStep ) )+ ( ( (lv_outcome_10_0= ruleOutcome ) ) | ( ruleKeywordChildListBegins otherlv_12= ':' ( (lv_blocks_13_0= ruleExtensionBlock ) )+ ruleKeywordChildListEnds ) ) )
            // InternalUcm4iot.g:1600:3: ruleKeywordAlternateBlock otherlv_1= 'for' ( ( ( ruleStepNumber ) ) | ( ( (lv_hasRangedRef_3_0= '(' ) ) ( ( ruleStepNumber ) ) otherlv_5= '-' ( ( ruleStepNumber ) ) otherlv_7= ')' ) ) otherlv_8= ':' ( (lv_steps_9_0= ruleStep ) )+ ( ( (lv_outcome_10_0= ruleOutcome ) ) | ( ruleKeywordChildListBegins otherlv_12= ':' ( (lv_blocks_13_0= ruleExtensionBlock ) )+ ruleKeywordChildListEnds ) )
            {

            			newCompositeNode(grammarAccess.getAlternateBlockAccess().getKeywordAlternateBlockParserRuleCall_0());
            		
            pushFollow(FOLLOW_25);
            ruleKeywordAlternateBlock();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		
            otherlv_1=(Token)match(input,17,FOLLOW_26); 

            			newLeafNode(otherlv_1, grammarAccess.getAlternateBlockAccess().getForKeyword_1());
            		
            // InternalUcm4iot.g:1611:3: ( ( ( ruleStepNumber ) ) | ( ( (lv_hasRangedRef_3_0= '(' ) ) ( ( ruleStepNumber ) ) otherlv_5= '-' ( ( ruleStepNumber ) ) otherlv_7= ')' ) )
            int alt30=2;
            alt30 = dfa30.predict(input);
            switch (alt30) {
                case 1 :
                    // InternalUcm4iot.g:1612:4: ( ( ruleStepNumber ) )
                    {
                    // InternalUcm4iot.g:1612:4: ( ( ruleStepNumber ) )
                    // InternalUcm4iot.g:1613:5: ( ruleStepNumber )
                    {
                    // InternalUcm4iot.g:1613:5: ( ruleStepNumber )
                    // InternalUcm4iot.g:1614:6: ruleStepNumber
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAlternateBlockRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getAlternateBlockAccess().getRefStepStepCrossReference_2_0_0());
                    					
                    pushFollow(FOLLOW_4);
                    ruleStepNumber();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:1629:4: ( ( (lv_hasRangedRef_3_0= '(' ) ) ( ( ruleStepNumber ) ) otherlv_5= '-' ( ( ruleStepNumber ) ) otherlv_7= ')' )
                    {
                    // InternalUcm4iot.g:1629:4: ( ( (lv_hasRangedRef_3_0= '(' ) ) ( ( ruleStepNumber ) ) otherlv_5= '-' ( ( ruleStepNumber ) ) otherlv_7= ')' )
                    // InternalUcm4iot.g:1630:5: ( (lv_hasRangedRef_3_0= '(' ) ) ( ( ruleStepNumber ) ) otherlv_5= '-' ( ( ruleStepNumber ) ) otherlv_7= ')'
                    {
                    // InternalUcm4iot.g:1630:5: ( (lv_hasRangedRef_3_0= '(' ) )
                    // InternalUcm4iot.g:1631:6: (lv_hasRangedRef_3_0= '(' )
                    {
                    // InternalUcm4iot.g:1631:6: (lv_hasRangedRef_3_0= '(' )
                    // InternalUcm4iot.g:1632:7: lv_hasRangedRef_3_0= '('
                    {
                    lv_hasRangedRef_3_0=(Token)match(input,18,FOLLOW_26); 

                    							newLeafNode(lv_hasRangedRef_3_0, grammarAccess.getAlternateBlockAccess().getHasRangedRefLeftParenthesisKeyword_2_1_0_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getAlternateBlockRule());
                    							}
                    							setWithLastConsumed(current, "hasRangedRef", lv_hasRangedRef_3_0 != null, "(");
                    						

                    }


                    }

                    // InternalUcm4iot.g:1644:5: ( ( ruleStepNumber ) )
                    // InternalUcm4iot.g:1645:6: ( ruleStepNumber )
                    {
                    // InternalUcm4iot.g:1645:6: ( ruleStepNumber )
                    // InternalUcm4iot.g:1646:7: ruleStepNumber
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getAlternateBlockRule());
                    							}
                    						

                    							newCompositeNode(grammarAccess.getAlternateBlockAccess().getRefStepStepCrossReference_2_1_1_0());
                    						
                    pushFollow(FOLLOW_27);
                    ruleStepNumber();

                    state._fsp--;


                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    otherlv_5=(Token)match(input,19,FOLLOW_26); 

                    					newLeafNode(otherlv_5, grammarAccess.getAlternateBlockAccess().getHyphenMinusKeyword_2_1_2());
                    				
                    // InternalUcm4iot.g:1664:5: ( ( ruleStepNumber ) )
                    // InternalUcm4iot.g:1665:6: ( ruleStepNumber )
                    {
                    // InternalUcm4iot.g:1665:6: ( ruleStepNumber )
                    // InternalUcm4iot.g:1666:7: ruleStepNumber
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getAlternateBlockRule());
                    							}
                    						

                    							newCompositeNode(grammarAccess.getAlternateBlockAccess().getEndRefStepStepCrossReference_2_1_3_0());
                    						
                    pushFollow(FOLLOW_28);
                    ruleStepNumber();

                    state._fsp--;


                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    otherlv_7=(Token)match(input,20,FOLLOW_4); 

                    					newLeafNode(otherlv_7, grammarAccess.getAlternateBlockAccess().getRightParenthesisKeyword_2_1_4());
                    				

                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,13,FOLLOW_8); 

            			newLeafNode(otherlv_8, grammarAccess.getAlternateBlockAccess().getColonKeyword_3());
            		
            // InternalUcm4iot.g:1690:3: ( (lv_steps_9_0= ruleStep ) )+
            int cnt31=0;
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>=RULE_STRING && LA31_0<=RULE_INT)||LA31_0==18) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalUcm4iot.g:1691:4: (lv_steps_9_0= ruleStep )
            	    {
            	    // InternalUcm4iot.g:1691:4: (lv_steps_9_0= ruleStep )
            	    // InternalUcm4iot.g:1692:5: lv_steps_9_0= ruleStep
            	    {

            	    					newCompositeNode(grammarAccess.getAlternateBlockAccess().getStepsStepParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_29);
            	    lv_steps_9_0=ruleStep();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getAlternateBlockRule());
            	    					}
            	    					add(
            	    						current,
            	    						"steps",
            	    						lv_steps_9_0,
            	    						"mde.iot.ucm4iot.Ucm4iot.Step");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt31 >= 1 ) break loop31;
                        EarlyExitException eee =
                            new EarlyExitException(31, input);
                        throw eee;
                }
                cnt31++;
            } while (true);

            // InternalUcm4iot.g:1709:3: ( ( (lv_outcome_10_0= ruleOutcome ) ) | ( ruleKeywordChildListBegins otherlv_12= ':' ( (lv_blocks_13_0= ruleExtensionBlock ) )+ ruleKeywordChildListEnds ) )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=38 && LA33_0<=39)) ) {
                alt33=1;
            }
            else if ( ((LA33_0>=76 && LA33_0<=77)) ) {
                alt33=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // InternalUcm4iot.g:1710:4: ( (lv_outcome_10_0= ruleOutcome ) )
                    {
                    // InternalUcm4iot.g:1710:4: ( (lv_outcome_10_0= ruleOutcome ) )
                    // InternalUcm4iot.g:1711:5: (lv_outcome_10_0= ruleOutcome )
                    {
                    // InternalUcm4iot.g:1711:5: (lv_outcome_10_0= ruleOutcome )
                    // InternalUcm4iot.g:1712:6: lv_outcome_10_0= ruleOutcome
                    {

                    						newCompositeNode(grammarAccess.getAlternateBlockAccess().getOutcomeOutcomeParserRuleCall_5_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_outcome_10_0=ruleOutcome();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAlternateBlockRule());
                    						}
                    						set(
                    							current,
                    							"outcome",
                    							lv_outcome_10_0,
                    							"mde.iot.ucm4iot.Ucm4iot.Outcome");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:1730:4: ( ruleKeywordChildListBegins otherlv_12= ':' ( (lv_blocks_13_0= ruleExtensionBlock ) )+ ruleKeywordChildListEnds )
                    {
                    // InternalUcm4iot.g:1730:4: ( ruleKeywordChildListBegins otherlv_12= ':' ( (lv_blocks_13_0= ruleExtensionBlock ) )+ ruleKeywordChildListEnds )
                    // InternalUcm4iot.g:1731:5: ruleKeywordChildListBegins otherlv_12= ':' ( (lv_blocks_13_0= ruleExtensionBlock ) )+ ruleKeywordChildListEnds
                    {

                    					newCompositeNode(grammarAccess.getAlternateBlockAccess().getKeywordChildListBeginsParserRuleCall_5_1_0());
                    				
                    pushFollow(FOLLOW_4);
                    ruleKeywordChildListBegins();

                    state._fsp--;


                    					afterParserOrEnumRuleCall();
                    				
                    otherlv_12=(Token)match(input,13,FOLLOW_10); 

                    					newLeafNode(otherlv_12, grammarAccess.getAlternateBlockAccess().getColonKeyword_5_1_1());
                    				
                    // InternalUcm4iot.g:1742:5: ( (lv_blocks_13_0= ruleExtensionBlock ) )+
                    int cnt32=0;
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( ((LA32_0>=72 && LA32_0<=75)) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // InternalUcm4iot.g:1743:6: (lv_blocks_13_0= ruleExtensionBlock )
                    	    {
                    	    // InternalUcm4iot.g:1743:6: (lv_blocks_13_0= ruleExtensionBlock )
                    	    // InternalUcm4iot.g:1744:7: lv_blocks_13_0= ruleExtensionBlock
                    	    {

                    	    							newCompositeNode(grammarAccess.getAlternateBlockAccess().getBlocksExtensionBlockParserRuleCall_5_1_2_0());
                    	    						
                    	    pushFollow(FOLLOW_30);
                    	    lv_blocks_13_0=ruleExtensionBlock();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getAlternateBlockRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"blocks",
                    	    								lv_blocks_13_0,
                    	    								"mde.iot.ucm4iot.Ucm4iot.ExtensionBlock");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt32 >= 1 ) break loop32;
                                EarlyExitException eee =
                                    new EarlyExitException(32, input);
                                throw eee;
                        }
                        cnt32++;
                    } while (true);


                    					newCompositeNode(grammarAccess.getAlternateBlockAccess().getKeywordChildListEndsParserRuleCall_5_1_3());
                    				
                    pushFollow(FOLLOW_2);
                    ruleKeywordChildListEnds();

                    state._fsp--;


                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAlternateBlock"


    // $ANTLR start "entryRuleExceptionalBlock"
    // InternalUcm4iot.g:1774:1: entryRuleExceptionalBlock returns [EObject current=null] : iv_ruleExceptionalBlock= ruleExceptionalBlock EOF ;
    public final EObject entryRuleExceptionalBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExceptionalBlock = null;


        try {
            // InternalUcm4iot.g:1774:57: (iv_ruleExceptionalBlock= ruleExceptionalBlock EOF )
            // InternalUcm4iot.g:1775:2: iv_ruleExceptionalBlock= ruleExceptionalBlock EOF
            {
             newCompositeNode(grammarAccess.getExceptionalBlockRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExceptionalBlock=ruleExceptionalBlock();

            state._fsp--;

             current =iv_ruleExceptionalBlock; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExceptionalBlock"


    // $ANTLR start "ruleExceptionalBlock"
    // InternalUcm4iot.g:1781:1: ruleExceptionalBlock returns [EObject current=null] : ( ruleKeywordExceptionalBlock otherlv_1= 'for' ( ( ( ruleStepNumber ) ) | ( ( (lv_hasRangedRef_3_0= '(' ) ) ( ( ruleStepNumber ) ) otherlv_5= '-' ( ( ruleStepNumber ) ) otherlv_7= ')' ) ) otherlv_8= ':' ( (lv_steps_9_0= ruleStep ) )+ ( ( (lv_outcome_10_0= ruleOutcome ) ) | ( ruleKeywordChildListBegins otherlv_12= ':' ( (lv_blocks_13_0= ruleExtensionBlock ) )+ ruleKeywordChildListEnds ) ) ) ;
    public final EObject ruleExceptionalBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_hasRangedRef_3_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_12=null;
        EObject lv_steps_9_0 = null;

        EObject lv_outcome_10_0 = null;

        EObject lv_blocks_13_0 = null;



        	enterRule();

        try {
            // InternalUcm4iot.g:1787:2: ( ( ruleKeywordExceptionalBlock otherlv_1= 'for' ( ( ( ruleStepNumber ) ) | ( ( (lv_hasRangedRef_3_0= '(' ) ) ( ( ruleStepNumber ) ) otherlv_5= '-' ( ( ruleStepNumber ) ) otherlv_7= ')' ) ) otherlv_8= ':' ( (lv_steps_9_0= ruleStep ) )+ ( ( (lv_outcome_10_0= ruleOutcome ) ) | ( ruleKeywordChildListBegins otherlv_12= ':' ( (lv_blocks_13_0= ruleExtensionBlock ) )+ ruleKeywordChildListEnds ) ) ) )
            // InternalUcm4iot.g:1788:2: ( ruleKeywordExceptionalBlock otherlv_1= 'for' ( ( ( ruleStepNumber ) ) | ( ( (lv_hasRangedRef_3_0= '(' ) ) ( ( ruleStepNumber ) ) otherlv_5= '-' ( ( ruleStepNumber ) ) otherlv_7= ')' ) ) otherlv_8= ':' ( (lv_steps_9_0= ruleStep ) )+ ( ( (lv_outcome_10_0= ruleOutcome ) ) | ( ruleKeywordChildListBegins otherlv_12= ':' ( (lv_blocks_13_0= ruleExtensionBlock ) )+ ruleKeywordChildListEnds ) ) )
            {
            // InternalUcm4iot.g:1788:2: ( ruleKeywordExceptionalBlock otherlv_1= 'for' ( ( ( ruleStepNumber ) ) | ( ( (lv_hasRangedRef_3_0= '(' ) ) ( ( ruleStepNumber ) ) otherlv_5= '-' ( ( ruleStepNumber ) ) otherlv_7= ')' ) ) otherlv_8= ':' ( (lv_steps_9_0= ruleStep ) )+ ( ( (lv_outcome_10_0= ruleOutcome ) ) | ( ruleKeywordChildListBegins otherlv_12= ':' ( (lv_blocks_13_0= ruleExtensionBlock ) )+ ruleKeywordChildListEnds ) ) )
            // InternalUcm4iot.g:1789:3: ruleKeywordExceptionalBlock otherlv_1= 'for' ( ( ( ruleStepNumber ) ) | ( ( (lv_hasRangedRef_3_0= '(' ) ) ( ( ruleStepNumber ) ) otherlv_5= '-' ( ( ruleStepNumber ) ) otherlv_7= ')' ) ) otherlv_8= ':' ( (lv_steps_9_0= ruleStep ) )+ ( ( (lv_outcome_10_0= ruleOutcome ) ) | ( ruleKeywordChildListBegins otherlv_12= ':' ( (lv_blocks_13_0= ruleExtensionBlock ) )+ ruleKeywordChildListEnds ) )
            {

            			newCompositeNode(grammarAccess.getExceptionalBlockAccess().getKeywordExceptionalBlockParserRuleCall_0());
            		
            pushFollow(FOLLOW_25);
            ruleKeywordExceptionalBlock();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		
            otherlv_1=(Token)match(input,17,FOLLOW_26); 

            			newLeafNode(otherlv_1, grammarAccess.getExceptionalBlockAccess().getForKeyword_1());
            		
            // InternalUcm4iot.g:1800:3: ( ( ( ruleStepNumber ) ) | ( ( (lv_hasRangedRef_3_0= '(' ) ) ( ( ruleStepNumber ) ) otherlv_5= '-' ( ( ruleStepNumber ) ) otherlv_7= ')' ) )
            int alt34=2;
            alt34 = dfa34.predict(input);
            switch (alt34) {
                case 1 :
                    // InternalUcm4iot.g:1801:4: ( ( ruleStepNumber ) )
                    {
                    // InternalUcm4iot.g:1801:4: ( ( ruleStepNumber ) )
                    // InternalUcm4iot.g:1802:5: ( ruleStepNumber )
                    {
                    // InternalUcm4iot.g:1802:5: ( ruleStepNumber )
                    // InternalUcm4iot.g:1803:6: ruleStepNumber
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExceptionalBlockRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getExceptionalBlockAccess().getRefStepStepCrossReference_2_0_0());
                    					
                    pushFollow(FOLLOW_4);
                    ruleStepNumber();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:1818:4: ( ( (lv_hasRangedRef_3_0= '(' ) ) ( ( ruleStepNumber ) ) otherlv_5= '-' ( ( ruleStepNumber ) ) otherlv_7= ')' )
                    {
                    // InternalUcm4iot.g:1818:4: ( ( (lv_hasRangedRef_3_0= '(' ) ) ( ( ruleStepNumber ) ) otherlv_5= '-' ( ( ruleStepNumber ) ) otherlv_7= ')' )
                    // InternalUcm4iot.g:1819:5: ( (lv_hasRangedRef_3_0= '(' ) ) ( ( ruleStepNumber ) ) otherlv_5= '-' ( ( ruleStepNumber ) ) otherlv_7= ')'
                    {
                    // InternalUcm4iot.g:1819:5: ( (lv_hasRangedRef_3_0= '(' ) )
                    // InternalUcm4iot.g:1820:6: (lv_hasRangedRef_3_0= '(' )
                    {
                    // InternalUcm4iot.g:1820:6: (lv_hasRangedRef_3_0= '(' )
                    // InternalUcm4iot.g:1821:7: lv_hasRangedRef_3_0= '('
                    {
                    lv_hasRangedRef_3_0=(Token)match(input,18,FOLLOW_26); 

                    							newLeafNode(lv_hasRangedRef_3_0, grammarAccess.getExceptionalBlockAccess().getHasRangedRefLeftParenthesisKeyword_2_1_0_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getExceptionalBlockRule());
                    							}
                    							setWithLastConsumed(current, "hasRangedRef", lv_hasRangedRef_3_0 != null, "(");
                    						

                    }


                    }

                    // InternalUcm4iot.g:1833:5: ( ( ruleStepNumber ) )
                    // InternalUcm4iot.g:1834:6: ( ruleStepNumber )
                    {
                    // InternalUcm4iot.g:1834:6: ( ruleStepNumber )
                    // InternalUcm4iot.g:1835:7: ruleStepNumber
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getExceptionalBlockRule());
                    							}
                    						

                    							newCompositeNode(grammarAccess.getExceptionalBlockAccess().getRefStepStepCrossReference_2_1_1_0());
                    						
                    pushFollow(FOLLOW_27);
                    ruleStepNumber();

                    state._fsp--;


                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    otherlv_5=(Token)match(input,19,FOLLOW_26); 

                    					newLeafNode(otherlv_5, grammarAccess.getExceptionalBlockAccess().getHyphenMinusKeyword_2_1_2());
                    				
                    // InternalUcm4iot.g:1853:5: ( ( ruleStepNumber ) )
                    // InternalUcm4iot.g:1854:6: ( ruleStepNumber )
                    {
                    // InternalUcm4iot.g:1854:6: ( ruleStepNumber )
                    // InternalUcm4iot.g:1855:7: ruleStepNumber
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getExceptionalBlockRule());
                    							}
                    						

                    							newCompositeNode(grammarAccess.getExceptionalBlockAccess().getEndRefStepStepCrossReference_2_1_3_0());
                    						
                    pushFollow(FOLLOW_28);
                    ruleStepNumber();

                    state._fsp--;


                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    otherlv_7=(Token)match(input,20,FOLLOW_4); 

                    					newLeafNode(otherlv_7, grammarAccess.getExceptionalBlockAccess().getRightParenthesisKeyword_2_1_4());
                    				

                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,13,FOLLOW_8); 

            			newLeafNode(otherlv_8, grammarAccess.getExceptionalBlockAccess().getColonKeyword_3());
            		
            // InternalUcm4iot.g:1879:3: ( (lv_steps_9_0= ruleStep ) )+
            int cnt35=0;
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( ((LA35_0>=RULE_STRING && LA35_0<=RULE_INT)||LA35_0==18) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalUcm4iot.g:1880:4: (lv_steps_9_0= ruleStep )
            	    {
            	    // InternalUcm4iot.g:1880:4: (lv_steps_9_0= ruleStep )
            	    // InternalUcm4iot.g:1881:5: lv_steps_9_0= ruleStep
            	    {

            	    					newCompositeNode(grammarAccess.getExceptionalBlockAccess().getStepsStepParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_29);
            	    lv_steps_9_0=ruleStep();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getExceptionalBlockRule());
            	    					}
            	    					add(
            	    						current,
            	    						"steps",
            	    						lv_steps_9_0,
            	    						"mde.iot.ucm4iot.Ucm4iot.Step");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt35 >= 1 ) break loop35;
                        EarlyExitException eee =
                            new EarlyExitException(35, input);
                        throw eee;
                }
                cnt35++;
            } while (true);

            // InternalUcm4iot.g:1898:3: ( ( (lv_outcome_10_0= ruleOutcome ) ) | ( ruleKeywordChildListBegins otherlv_12= ':' ( (lv_blocks_13_0= ruleExtensionBlock ) )+ ruleKeywordChildListEnds ) )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( ((LA37_0>=38 && LA37_0<=39)) ) {
                alt37=1;
            }
            else if ( ((LA37_0>=76 && LA37_0<=77)) ) {
                alt37=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // InternalUcm4iot.g:1899:4: ( (lv_outcome_10_0= ruleOutcome ) )
                    {
                    // InternalUcm4iot.g:1899:4: ( (lv_outcome_10_0= ruleOutcome ) )
                    // InternalUcm4iot.g:1900:5: (lv_outcome_10_0= ruleOutcome )
                    {
                    // InternalUcm4iot.g:1900:5: (lv_outcome_10_0= ruleOutcome )
                    // InternalUcm4iot.g:1901:6: lv_outcome_10_0= ruleOutcome
                    {

                    						newCompositeNode(grammarAccess.getExceptionalBlockAccess().getOutcomeOutcomeParserRuleCall_5_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_outcome_10_0=ruleOutcome();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getExceptionalBlockRule());
                    						}
                    						set(
                    							current,
                    							"outcome",
                    							lv_outcome_10_0,
                    							"mde.iot.ucm4iot.Ucm4iot.Outcome");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:1919:4: ( ruleKeywordChildListBegins otherlv_12= ':' ( (lv_blocks_13_0= ruleExtensionBlock ) )+ ruleKeywordChildListEnds )
                    {
                    // InternalUcm4iot.g:1919:4: ( ruleKeywordChildListBegins otherlv_12= ':' ( (lv_blocks_13_0= ruleExtensionBlock ) )+ ruleKeywordChildListEnds )
                    // InternalUcm4iot.g:1920:5: ruleKeywordChildListBegins otherlv_12= ':' ( (lv_blocks_13_0= ruleExtensionBlock ) )+ ruleKeywordChildListEnds
                    {

                    					newCompositeNode(grammarAccess.getExceptionalBlockAccess().getKeywordChildListBeginsParserRuleCall_5_1_0());
                    				
                    pushFollow(FOLLOW_4);
                    ruleKeywordChildListBegins();

                    state._fsp--;


                    					afterParserOrEnumRuleCall();
                    				
                    otherlv_12=(Token)match(input,13,FOLLOW_10); 

                    					newLeafNode(otherlv_12, grammarAccess.getExceptionalBlockAccess().getColonKeyword_5_1_1());
                    				
                    // InternalUcm4iot.g:1931:5: ( (lv_blocks_13_0= ruleExtensionBlock ) )+
                    int cnt36=0;
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( ((LA36_0>=72 && LA36_0<=75)) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // InternalUcm4iot.g:1932:6: (lv_blocks_13_0= ruleExtensionBlock )
                    	    {
                    	    // InternalUcm4iot.g:1932:6: (lv_blocks_13_0= ruleExtensionBlock )
                    	    // InternalUcm4iot.g:1933:7: lv_blocks_13_0= ruleExtensionBlock
                    	    {

                    	    							newCompositeNode(grammarAccess.getExceptionalBlockAccess().getBlocksExtensionBlockParserRuleCall_5_1_2_0());
                    	    						
                    	    pushFollow(FOLLOW_30);
                    	    lv_blocks_13_0=ruleExtensionBlock();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getExceptionalBlockRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"blocks",
                    	    								lv_blocks_13_0,
                    	    								"mde.iot.ucm4iot.Ucm4iot.ExtensionBlock");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt36 >= 1 ) break loop36;
                                EarlyExitException eee =
                                    new EarlyExitException(36, input);
                                throw eee;
                        }
                        cnt36++;
                    } while (true);


                    					newCompositeNode(grammarAccess.getExceptionalBlockAccess().getKeywordChildListEndsParserRuleCall_5_1_3());
                    				
                    pushFollow(FOLLOW_2);
                    ruleKeywordChildListEnds();

                    state._fsp--;


                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExceptionalBlock"


    // $ANTLR start "entryRuleOutcome"
    // InternalUcm4iot.g:1963:1: entryRuleOutcome returns [EObject current=null] : iv_ruleOutcome= ruleOutcome EOF ;
    public final EObject entryRuleOutcome() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutcome = null;


        try {
            // InternalUcm4iot.g:1963:48: (iv_ruleOutcome= ruleOutcome EOF )
            // InternalUcm4iot.g:1964:2: iv_ruleOutcome= ruleOutcome EOF
            {
             newCompositeNode(grammarAccess.getOutcomeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOutcome=ruleOutcome();

            state._fsp--;

             current =iv_ruleOutcome; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOutcome"


    // $ANTLR start "ruleOutcome"
    // InternalUcm4iot.g:1970:1: ruleOutcome returns [EObject current=null] : (this_OutcomeEnds_0= ruleOutcomeEnds | this_OutcomeContinues_1= ruleOutcomeContinues ) ;
    public final EObject ruleOutcome() throws RecognitionException {
        EObject current = null;

        EObject this_OutcomeEnds_0 = null;

        EObject this_OutcomeContinues_1 = null;



        	enterRule();

        try {
            // InternalUcm4iot.g:1976:2: ( (this_OutcomeEnds_0= ruleOutcomeEnds | this_OutcomeContinues_1= ruleOutcomeContinues ) )
            // InternalUcm4iot.g:1977:2: (this_OutcomeEnds_0= ruleOutcomeEnds | this_OutcomeContinues_1= ruleOutcomeContinues )
            {
            // InternalUcm4iot.g:1977:2: (this_OutcomeEnds_0= ruleOutcomeEnds | this_OutcomeContinues_1= ruleOutcomeContinues )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==38) ) {
                int LA38_1 = input.LA(2);

                if ( (LA38_1==40) ) {
                    int LA38_3 = input.LA(3);

                    if ( ((LA38_3>=96 && LA38_3<=97)) ) {
                        alt38=2;
                    }
                    else if ( ((LA38_3>=80 && LA38_3<=81)) ) {
                        alt38=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 38, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA38_1==41) ) {
                    int LA38_4 = input.LA(3);

                    if ( ((LA38_4>=96 && LA38_4<=97)) ) {
                        alt38=2;
                    }
                    else if ( ((LA38_4>=80 && LA38_4<=81)) ) {
                        alt38=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 38, 4, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA38_0==39) ) {
                int LA38_2 = input.LA(2);

                if ( (LA38_2==40) ) {
                    int LA38_3 = input.LA(3);

                    if ( ((LA38_3>=96 && LA38_3<=97)) ) {
                        alt38=2;
                    }
                    else if ( ((LA38_3>=80 && LA38_3<=81)) ) {
                        alt38=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 38, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA38_2==41) ) {
                    int LA38_4 = input.LA(3);

                    if ( ((LA38_4>=96 && LA38_4<=97)) ) {
                        alt38=2;
                    }
                    else if ( ((LA38_4>=80 && LA38_4<=81)) ) {
                        alt38=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 38, 4, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // InternalUcm4iot.g:1978:3: this_OutcomeEnds_0= ruleOutcomeEnds
                    {

                    			newCompositeNode(grammarAccess.getOutcomeAccess().getOutcomeEndsParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_OutcomeEnds_0=ruleOutcomeEnds();

                    state._fsp--;


                    			current = this_OutcomeEnds_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:1987:3: this_OutcomeContinues_1= ruleOutcomeContinues
                    {

                    			newCompositeNode(grammarAccess.getOutcomeAccess().getOutcomeContinuesParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_OutcomeContinues_1=ruleOutcomeContinues();

                    state._fsp--;


                    			current = this_OutcomeContinues_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOutcome"


    // $ANTLR start "entryRuleOutcomeEnds"
    // InternalUcm4iot.g:1999:1: entryRuleOutcomeEnds returns [EObject current=null] : iv_ruleOutcomeEnds= ruleOutcomeEnds EOF ;
    public final EObject entryRuleOutcomeEnds() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutcomeEnds = null;


        try {
            // InternalUcm4iot.g:1999:52: (iv_ruleOutcomeEnds= ruleOutcomeEnds EOF )
            // InternalUcm4iot.g:2000:2: iv_ruleOutcomeEnds= ruleOutcomeEnds EOF
            {
             newCompositeNode(grammarAccess.getOutcomeEndsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOutcomeEnds=ruleOutcomeEnds();

            state._fsp--;

             current =iv_ruleOutcomeEnds; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOutcomeEnds"


    // $ANTLR start "ruleOutcomeEnds"
    // InternalUcm4iot.g:2006:1: ruleOutcomeEnds returns [EObject current=null] : ( ruleKeywordOutcomeEnds otherlv_1= ':' ( (lv_type_2_0= ruleOutcomeEndings ) ) ) ;
    public final EObject ruleOutcomeEnds() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Enumerator lv_type_2_0 = null;



        	enterRule();

        try {
            // InternalUcm4iot.g:2012:2: ( ( ruleKeywordOutcomeEnds otherlv_1= ':' ( (lv_type_2_0= ruleOutcomeEndings ) ) ) )
            // InternalUcm4iot.g:2013:2: ( ruleKeywordOutcomeEnds otherlv_1= ':' ( (lv_type_2_0= ruleOutcomeEndings ) ) )
            {
            // InternalUcm4iot.g:2013:2: ( ruleKeywordOutcomeEnds otherlv_1= ':' ( (lv_type_2_0= ruleOutcomeEndings ) ) )
            // InternalUcm4iot.g:2014:3: ruleKeywordOutcomeEnds otherlv_1= ':' ( (lv_type_2_0= ruleOutcomeEndings ) )
            {

            			newCompositeNode(grammarAccess.getOutcomeEndsAccess().getKeywordOutcomeEndsParserRuleCall_0());
            		
            pushFollow(FOLLOW_4);
            ruleKeywordOutcomeEnds();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		
            otherlv_1=(Token)match(input,13,FOLLOW_31); 

            			newLeafNode(otherlv_1, grammarAccess.getOutcomeEndsAccess().getColonKeyword_1());
            		
            // InternalUcm4iot.g:2025:3: ( (lv_type_2_0= ruleOutcomeEndings ) )
            // InternalUcm4iot.g:2026:4: (lv_type_2_0= ruleOutcomeEndings )
            {
            // InternalUcm4iot.g:2026:4: (lv_type_2_0= ruleOutcomeEndings )
            // InternalUcm4iot.g:2027:5: lv_type_2_0= ruleOutcomeEndings
            {

            					newCompositeNode(grammarAccess.getOutcomeEndsAccess().getTypeOutcomeEndingsEnumRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_type_2_0=ruleOutcomeEndings();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOutcomeEndsRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_2_0,
            						"mde.iot.ucm4iot.Ucm4iot.OutcomeEndings");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOutcomeEnds"


    // $ANTLR start "entryRuleOutcomeContinues"
    // InternalUcm4iot.g:2048:1: entryRuleOutcomeContinues returns [EObject current=null] : iv_ruleOutcomeContinues= ruleOutcomeContinues EOF ;
    public final EObject entryRuleOutcomeContinues() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutcomeContinues = null;


        try {
            // InternalUcm4iot.g:2048:57: (iv_ruleOutcomeContinues= ruleOutcomeContinues EOF )
            // InternalUcm4iot.g:2049:2: iv_ruleOutcomeContinues= ruleOutcomeContinues EOF
            {
             newCompositeNode(grammarAccess.getOutcomeContinuesRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOutcomeContinues=ruleOutcomeContinues();

            state._fsp--;

             current =iv_ruleOutcomeContinues; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOutcomeContinues"


    // $ANTLR start "ruleOutcomeContinues"
    // InternalUcm4iot.g:2055:1: ruleOutcomeContinues returns [EObject current=null] : ( ruleKeywordOutcomeCont otherlv_1= ':' ( ( ruleStepNumber ) ) ) ;
    public final EObject ruleOutcomeContinues() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalUcm4iot.g:2061:2: ( ( ruleKeywordOutcomeCont otherlv_1= ':' ( ( ruleStepNumber ) ) ) )
            // InternalUcm4iot.g:2062:2: ( ruleKeywordOutcomeCont otherlv_1= ':' ( ( ruleStepNumber ) ) )
            {
            // InternalUcm4iot.g:2062:2: ( ruleKeywordOutcomeCont otherlv_1= ':' ( ( ruleStepNumber ) ) )
            // InternalUcm4iot.g:2063:3: ruleKeywordOutcomeCont otherlv_1= ':' ( ( ruleStepNumber ) )
            {

            			newCompositeNode(grammarAccess.getOutcomeContinuesAccess().getKeywordOutcomeContParserRuleCall_0());
            		
            pushFollow(FOLLOW_4);
            ruleKeywordOutcomeCont();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		
            otherlv_1=(Token)match(input,13,FOLLOW_26); 

            			newLeafNode(otherlv_1, grammarAccess.getOutcomeContinuesAccess().getColonKeyword_1());
            		
            // InternalUcm4iot.g:2074:3: ( ( ruleStepNumber ) )
            // InternalUcm4iot.g:2075:4: ( ruleStepNumber )
            {
            // InternalUcm4iot.g:2075:4: ( ruleStepNumber )
            // InternalUcm4iot.g:2076:5: ruleStepNumber
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOutcomeContinuesRule());
            					}
            				

            					newCompositeNode(grammarAccess.getOutcomeContinuesAccess().getStepStepCrossReference_2_0());
            				
            pushFollow(FOLLOW_2);
            ruleStepNumber();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOutcomeContinues"


    // $ANTLR start "entryRuleStep"
    // InternalUcm4iot.g:2094:1: entryRuleStep returns [EObject current=null] : iv_ruleStep= ruleStep EOF ;
    public final EObject entryRuleStep() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStep = null;


        try {
            // InternalUcm4iot.g:2094:45: (iv_ruleStep= ruleStep EOF )
            // InternalUcm4iot.g:2095:2: iv_ruleStep= ruleStep EOF
            {
             newCompositeNode(grammarAccess.getStepRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStep=ruleStep();

            state._fsp--;

             current =iv_ruleStep; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStep"


    // $ANTLR start "ruleStep"
    // InternalUcm4iot.g:2101:1: ruleStep returns [EObject current=null] : (this_InteractionStep_0= ruleInteractionStep | this_InvocationStep_1= ruleInvocationStep | this_ConditionControlStep_2= ruleConditionControlStep ) ;
    public final EObject ruleStep() throws RecognitionException {
        EObject current = null;

        EObject this_InteractionStep_0 = null;

        EObject this_InvocationStep_1 = null;

        EObject this_ConditionControlStep_2 = null;



        	enterRule();

        try {
            // InternalUcm4iot.g:2107:2: ( (this_InteractionStep_0= ruleInteractionStep | this_InvocationStep_1= ruleInvocationStep | this_ConditionControlStep_2= ruleConditionControlStep ) )
            // InternalUcm4iot.g:2108:2: (this_InteractionStep_0= ruleInteractionStep | this_InvocationStep_1= ruleInvocationStep | this_ConditionControlStep_2= ruleConditionControlStep )
            {
            // InternalUcm4iot.g:2108:2: (this_InteractionStep_0= ruleInteractionStep | this_InvocationStep_1= ruleInvocationStep | this_ConditionControlStep_2= ruleConditionControlStep )
            int alt39=3;
            alt39 = dfa39.predict(input);
            switch (alt39) {
                case 1 :
                    // InternalUcm4iot.g:2109:3: this_InteractionStep_0= ruleInteractionStep
                    {

                    			newCompositeNode(grammarAccess.getStepAccess().getInteractionStepParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_InteractionStep_0=ruleInteractionStep();

                    state._fsp--;


                    			current = this_InteractionStep_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:2118:3: this_InvocationStep_1= ruleInvocationStep
                    {

                    			newCompositeNode(grammarAccess.getStepAccess().getInvocationStepParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_InvocationStep_1=ruleInvocationStep();

                    state._fsp--;


                    			current = this_InvocationStep_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalUcm4iot.g:2127:3: this_ConditionControlStep_2= ruleConditionControlStep
                    {

                    			newCompositeNode(grammarAccess.getStepAccess().getConditionControlStepParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_ConditionControlStep_2=ruleConditionControlStep();

                    state._fsp--;


                    			current = this_ConditionControlStep_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStep"


    // $ANTLR start "entryRuleInteractionStep"
    // InternalUcm4iot.g:2139:1: entryRuleInteractionStep returns [EObject current=null] : iv_ruleInteractionStep= ruleInteractionStep EOF ;
    public final EObject entryRuleInteractionStep() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInteractionStep = null;


        try {
            // InternalUcm4iot.g:2139:56: (iv_ruleInteractionStep= ruleInteractionStep EOF )
            // InternalUcm4iot.g:2140:2: iv_ruleInteractionStep= ruleInteractionStep EOF
            {
             newCompositeNode(grammarAccess.getInteractionStepRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInteractionStep=ruleInteractionStep();

            state._fsp--;

             current =iv_ruleInteractionStep; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInteractionStep"


    // $ANTLR start "ruleInteractionStep"
    // InternalUcm4iot.g:2146:1: ruleInteractionStep returns [EObject current=null] : ( ( (lv_stepNumber_0_0= ruleStepNumber ) ) otherlv_1= '.' ( (lv_exception_2_0= ruleException ) )? ( ( (lv_description_3_0= RULE_STRING ) ) | ( (lv_ignoreDescription_4_0= RULE_IGNORE_STRING ) ) ) ) ;
    public final EObject ruleInteractionStep() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_description_3_0=null;
        Token lv_ignoreDescription_4_0=null;
        AntlrDatatypeRuleToken lv_stepNumber_0_0 = null;

        EObject lv_exception_2_0 = null;



        	enterRule();

        try {
            // InternalUcm4iot.g:2152:2: ( ( ( (lv_stepNumber_0_0= ruleStepNumber ) ) otherlv_1= '.' ( (lv_exception_2_0= ruleException ) )? ( ( (lv_description_3_0= RULE_STRING ) ) | ( (lv_ignoreDescription_4_0= RULE_IGNORE_STRING ) ) ) ) )
            // InternalUcm4iot.g:2153:2: ( ( (lv_stepNumber_0_0= ruleStepNumber ) ) otherlv_1= '.' ( (lv_exception_2_0= ruleException ) )? ( ( (lv_description_3_0= RULE_STRING ) ) | ( (lv_ignoreDescription_4_0= RULE_IGNORE_STRING ) ) ) )
            {
            // InternalUcm4iot.g:2153:2: ( ( (lv_stepNumber_0_0= ruleStepNumber ) ) otherlv_1= '.' ( (lv_exception_2_0= ruleException ) )? ( ( (lv_description_3_0= RULE_STRING ) ) | ( (lv_ignoreDescription_4_0= RULE_IGNORE_STRING ) ) ) )
            // InternalUcm4iot.g:2154:3: ( (lv_stepNumber_0_0= ruleStepNumber ) ) otherlv_1= '.' ( (lv_exception_2_0= ruleException ) )? ( ( (lv_description_3_0= RULE_STRING ) ) | ( (lv_ignoreDescription_4_0= RULE_IGNORE_STRING ) ) )
            {
            // InternalUcm4iot.g:2154:3: ( (lv_stepNumber_0_0= ruleStepNumber ) )
            // InternalUcm4iot.g:2155:4: (lv_stepNumber_0_0= ruleStepNumber )
            {
            // InternalUcm4iot.g:2155:4: (lv_stepNumber_0_0= ruleStepNumber )
            // InternalUcm4iot.g:2156:5: lv_stepNumber_0_0= ruleStepNumber
            {

            					newCompositeNode(grammarAccess.getInteractionStepAccess().getStepNumberStepNumberParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_32);
            lv_stepNumber_0_0=ruleStepNumber();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getInteractionStepRule());
            					}
            					set(
            						current,
            						"stepNumber",
            						lv_stepNumber_0_0,
            						"mde.iot.ucm4iot.Ucm4iot.StepNumber");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,21,FOLLOW_33); 

            			newLeafNode(otherlv_1, grammarAccess.getInteractionStepAccess().getFullStopKeyword_1());
            		
            // InternalUcm4iot.g:2177:3: ( (lv_exception_2_0= ruleException ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==24) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalUcm4iot.g:2178:4: (lv_exception_2_0= ruleException )
                    {
                    // InternalUcm4iot.g:2178:4: (lv_exception_2_0= ruleException )
                    // InternalUcm4iot.g:2179:5: lv_exception_2_0= ruleException
                    {

                    					newCompositeNode(grammarAccess.getInteractionStepAccess().getExceptionExceptionParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_34);
                    lv_exception_2_0=ruleException();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getInteractionStepRule());
                    					}
                    					set(
                    						current,
                    						"exception",
                    						lv_exception_2_0,
                    						"mde.iot.ucm4iot.Ucm4iot.Exception");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalUcm4iot.g:2196:3: ( ( (lv_description_3_0= RULE_STRING ) ) | ( (lv_ignoreDescription_4_0= RULE_IGNORE_STRING ) ) )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_STRING) ) {
                alt41=1;
            }
            else if ( (LA41_0==RULE_IGNORE_STRING) ) {
                alt41=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // InternalUcm4iot.g:2197:4: ( (lv_description_3_0= RULE_STRING ) )
                    {
                    // InternalUcm4iot.g:2197:4: ( (lv_description_3_0= RULE_STRING ) )
                    // InternalUcm4iot.g:2198:5: (lv_description_3_0= RULE_STRING )
                    {
                    // InternalUcm4iot.g:2198:5: (lv_description_3_0= RULE_STRING )
                    // InternalUcm4iot.g:2199:6: lv_description_3_0= RULE_STRING
                    {
                    lv_description_3_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_description_3_0, grammarAccess.getInteractionStepAccess().getDescriptionSTRINGTerminalRuleCall_3_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getInteractionStepRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"description",
                    							lv_description_3_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:2216:4: ( (lv_ignoreDescription_4_0= RULE_IGNORE_STRING ) )
                    {
                    // InternalUcm4iot.g:2216:4: ( (lv_ignoreDescription_4_0= RULE_IGNORE_STRING ) )
                    // InternalUcm4iot.g:2217:5: (lv_ignoreDescription_4_0= RULE_IGNORE_STRING )
                    {
                    // InternalUcm4iot.g:2217:5: (lv_ignoreDescription_4_0= RULE_IGNORE_STRING )
                    // InternalUcm4iot.g:2218:6: lv_ignoreDescription_4_0= RULE_IGNORE_STRING
                    {
                    lv_ignoreDescription_4_0=(Token)match(input,RULE_IGNORE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_ignoreDescription_4_0, grammarAccess.getInteractionStepAccess().getIgnoreDescriptionIGNORE_STRINGTerminalRuleCall_3_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getInteractionStepRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"ignoreDescription",
                    							lv_ignoreDescription_4_0 != null,
                    							"mde.iot.ucm4iot.Ucm4iot.IGNORE_STRING");
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInteractionStep"


    // $ANTLR start "entryRuleInvocationStep"
    // InternalUcm4iot.g:2239:1: entryRuleInvocationStep returns [EObject current=null] : iv_ruleInvocationStep= ruleInvocationStep EOF ;
    public final EObject entryRuleInvocationStep() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInvocationStep = null;


        try {
            // InternalUcm4iot.g:2239:55: (iv_ruleInvocationStep= ruleInvocationStep EOF )
            // InternalUcm4iot.g:2240:2: iv_ruleInvocationStep= ruleInvocationStep EOF
            {
             newCompositeNode(grammarAccess.getInvocationStepRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInvocationStep=ruleInvocationStep();

            state._fsp--;

             current =iv_ruleInvocationStep; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInvocationStep"


    // $ANTLR start "ruleInvocationStep"
    // InternalUcm4iot.g:2246:1: ruleInvocationStep returns [EObject current=null] : ( ( (lv_stepNumber_0_0= ruleStepNumber ) ) otherlv_1= '.' otherlv_2= '[' ( (otherlv_3= RULE_ID ) ) otherlv_4= ']' ( ( (lv_description_5_0= RULE_STRING ) ) | ( (lv_ignoreDescription_6_0= RULE_IGNORE_STRING ) ) ) ) ;
    public final EObject ruleInvocationStep() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_description_5_0=null;
        Token lv_ignoreDescription_6_0=null;
        AntlrDatatypeRuleToken lv_stepNumber_0_0 = null;



        	enterRule();

        try {
            // InternalUcm4iot.g:2252:2: ( ( ( (lv_stepNumber_0_0= ruleStepNumber ) ) otherlv_1= '.' otherlv_2= '[' ( (otherlv_3= RULE_ID ) ) otherlv_4= ']' ( ( (lv_description_5_0= RULE_STRING ) ) | ( (lv_ignoreDescription_6_0= RULE_IGNORE_STRING ) ) ) ) )
            // InternalUcm4iot.g:2253:2: ( ( (lv_stepNumber_0_0= ruleStepNumber ) ) otherlv_1= '.' otherlv_2= '[' ( (otherlv_3= RULE_ID ) ) otherlv_4= ']' ( ( (lv_description_5_0= RULE_STRING ) ) | ( (lv_ignoreDescription_6_0= RULE_IGNORE_STRING ) ) ) )
            {
            // InternalUcm4iot.g:2253:2: ( ( (lv_stepNumber_0_0= ruleStepNumber ) ) otherlv_1= '.' otherlv_2= '[' ( (otherlv_3= RULE_ID ) ) otherlv_4= ']' ( ( (lv_description_5_0= RULE_STRING ) ) | ( (lv_ignoreDescription_6_0= RULE_IGNORE_STRING ) ) ) )
            // InternalUcm4iot.g:2254:3: ( (lv_stepNumber_0_0= ruleStepNumber ) ) otherlv_1= '.' otherlv_2= '[' ( (otherlv_3= RULE_ID ) ) otherlv_4= ']' ( ( (lv_description_5_0= RULE_STRING ) ) | ( (lv_ignoreDescription_6_0= RULE_IGNORE_STRING ) ) )
            {
            // InternalUcm4iot.g:2254:3: ( (lv_stepNumber_0_0= ruleStepNumber ) )
            // InternalUcm4iot.g:2255:4: (lv_stepNumber_0_0= ruleStepNumber )
            {
            // InternalUcm4iot.g:2255:4: (lv_stepNumber_0_0= ruleStepNumber )
            // InternalUcm4iot.g:2256:5: lv_stepNumber_0_0= ruleStepNumber
            {

            					newCompositeNode(grammarAccess.getInvocationStepAccess().getStepNumberStepNumberParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_32);
            lv_stepNumber_0_0=ruleStepNumber();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getInvocationStepRule());
            					}
            					set(
            						current,
            						"stepNumber",
            						lv_stepNumber_0_0,
            						"mde.iot.ucm4iot.Ucm4iot.StepNumber");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,21,FOLLOW_35); 

            			newLeafNode(otherlv_1, grammarAccess.getInvocationStepAccess().getFullStopKeyword_1());
            		
            otherlv_2=(Token)match(input,22,FOLLOW_11); 

            			newLeafNode(otherlv_2, grammarAccess.getInvocationStepAccess().getLeftSquareBracketKeyword_2());
            		
            // InternalUcm4iot.g:2281:3: ( (otherlv_3= RULE_ID ) )
            // InternalUcm4iot.g:2282:4: (otherlv_3= RULE_ID )
            {
            // InternalUcm4iot.g:2282:4: (otherlv_3= RULE_ID )
            // InternalUcm4iot.g:2283:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInvocationStepRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_36); 

            					newLeafNode(otherlv_3, grammarAccess.getInvocationStepAccess().getInvokedUseCaseUseCaseCrossReference_3_0());
            				

            }


            }

            otherlv_4=(Token)match(input,23,FOLLOW_34); 

            			newLeafNode(otherlv_4, grammarAccess.getInvocationStepAccess().getRightSquareBracketKeyword_4());
            		
            // InternalUcm4iot.g:2298:3: ( ( (lv_description_5_0= RULE_STRING ) ) | ( (lv_ignoreDescription_6_0= RULE_IGNORE_STRING ) ) )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==RULE_STRING) ) {
                alt42=1;
            }
            else if ( (LA42_0==RULE_IGNORE_STRING) ) {
                alt42=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // InternalUcm4iot.g:2299:4: ( (lv_description_5_0= RULE_STRING ) )
                    {
                    // InternalUcm4iot.g:2299:4: ( (lv_description_5_0= RULE_STRING ) )
                    // InternalUcm4iot.g:2300:5: (lv_description_5_0= RULE_STRING )
                    {
                    // InternalUcm4iot.g:2300:5: (lv_description_5_0= RULE_STRING )
                    // InternalUcm4iot.g:2301:6: lv_description_5_0= RULE_STRING
                    {
                    lv_description_5_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_description_5_0, grammarAccess.getInvocationStepAccess().getDescriptionSTRINGTerminalRuleCall_5_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getInvocationStepRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"description",
                    							lv_description_5_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:2318:4: ( (lv_ignoreDescription_6_0= RULE_IGNORE_STRING ) )
                    {
                    // InternalUcm4iot.g:2318:4: ( (lv_ignoreDescription_6_0= RULE_IGNORE_STRING ) )
                    // InternalUcm4iot.g:2319:5: (lv_ignoreDescription_6_0= RULE_IGNORE_STRING )
                    {
                    // InternalUcm4iot.g:2319:5: (lv_ignoreDescription_6_0= RULE_IGNORE_STRING )
                    // InternalUcm4iot.g:2320:6: lv_ignoreDescription_6_0= RULE_IGNORE_STRING
                    {
                    lv_ignoreDescription_6_0=(Token)match(input,RULE_IGNORE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_ignoreDescription_6_0, grammarAccess.getInvocationStepAccess().getIgnoreDescriptionIGNORE_STRINGTerminalRuleCall_5_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getInvocationStepRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"ignoreDescription",
                    							lv_ignoreDescription_6_0 != null,
                    							"mde.iot.ucm4iot.Ucm4iot.IGNORE_STRING");
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInvocationStep"


    // $ANTLR start "entryRuleConditionControlStep"
    // InternalUcm4iot.g:2341:1: entryRuleConditionControlStep returns [EObject current=null] : iv_ruleConditionControlStep= ruleConditionControlStep EOF ;
    public final EObject entryRuleConditionControlStep() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionControlStep = null;


        try {
            // InternalUcm4iot.g:2341:61: (iv_ruleConditionControlStep= ruleConditionControlStep EOF )
            // InternalUcm4iot.g:2342:2: iv_ruleConditionControlStep= ruleConditionControlStep EOF
            {
             newCompositeNode(grammarAccess.getConditionControlStepRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConditionControlStep=ruleConditionControlStep();

            state._fsp--;

             current =iv_ruleConditionControlStep; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConditionControlStep"


    // $ANTLR start "ruleConditionControlStep"
    // InternalUcm4iot.g:2348:1: ruleConditionControlStep returns [EObject current=null] : ( ( (lv_description_0_0= RULE_STRING ) ) | ( (lv_ignoreDescription_1_0= RULE_IGNORE_STRING ) ) ) ;
    public final EObject ruleConditionControlStep() throws RecognitionException {
        EObject current = null;

        Token lv_description_0_0=null;
        Token lv_ignoreDescription_1_0=null;


        	enterRule();

        try {
            // InternalUcm4iot.g:2354:2: ( ( ( (lv_description_0_0= RULE_STRING ) ) | ( (lv_ignoreDescription_1_0= RULE_IGNORE_STRING ) ) ) )
            // InternalUcm4iot.g:2355:2: ( ( (lv_description_0_0= RULE_STRING ) ) | ( (lv_ignoreDescription_1_0= RULE_IGNORE_STRING ) ) )
            {
            // InternalUcm4iot.g:2355:2: ( ( (lv_description_0_0= RULE_STRING ) ) | ( (lv_ignoreDescription_1_0= RULE_IGNORE_STRING ) ) )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==RULE_STRING) ) {
                alt43=1;
            }
            else if ( (LA43_0==RULE_IGNORE_STRING) ) {
                alt43=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // InternalUcm4iot.g:2356:3: ( (lv_description_0_0= RULE_STRING ) )
                    {
                    // InternalUcm4iot.g:2356:3: ( (lv_description_0_0= RULE_STRING ) )
                    // InternalUcm4iot.g:2357:4: (lv_description_0_0= RULE_STRING )
                    {
                    // InternalUcm4iot.g:2357:4: (lv_description_0_0= RULE_STRING )
                    // InternalUcm4iot.g:2358:5: lv_description_0_0= RULE_STRING
                    {
                    lv_description_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    					newLeafNode(lv_description_0_0, grammarAccess.getConditionControlStepAccess().getDescriptionSTRINGTerminalRuleCall_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getConditionControlStepRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"description",
                    						lv_description_0_0,
                    						"org.eclipse.xtext.common.Terminals.STRING");
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:2375:3: ( (lv_ignoreDescription_1_0= RULE_IGNORE_STRING ) )
                    {
                    // InternalUcm4iot.g:2375:3: ( (lv_ignoreDescription_1_0= RULE_IGNORE_STRING ) )
                    // InternalUcm4iot.g:2376:4: (lv_ignoreDescription_1_0= RULE_IGNORE_STRING )
                    {
                    // InternalUcm4iot.g:2376:4: (lv_ignoreDescription_1_0= RULE_IGNORE_STRING )
                    // InternalUcm4iot.g:2377:5: lv_ignoreDescription_1_0= RULE_IGNORE_STRING
                    {
                    lv_ignoreDescription_1_0=(Token)match(input,RULE_IGNORE_STRING,FOLLOW_2); 

                    					newLeafNode(lv_ignoreDescription_1_0, grammarAccess.getConditionControlStepAccess().getIgnoreDescriptionIGNORE_STRINGTerminalRuleCall_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getConditionControlStepRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"ignoreDescription",
                    						lv_ignoreDescription_1_0 != null,
                    						"mde.iot.ucm4iot.Ucm4iot.IGNORE_STRING");
                    				

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConditionControlStep"


    // $ANTLR start "entryRuleStepNumber"
    // InternalUcm4iot.g:2397:1: entryRuleStepNumber returns [String current=null] : iv_ruleStepNumber= ruleStepNumber EOF ;
    public final String entryRuleStepNumber() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStepNumber = null;


        try {
            // InternalUcm4iot.g:2397:50: (iv_ruleStepNumber= ruleStepNumber EOF )
            // InternalUcm4iot.g:2398:2: iv_ruleStepNumber= ruleStepNumber EOF
            {
             newCompositeNode(grammarAccess.getStepNumberRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStepNumber=ruleStepNumber();

            state._fsp--;

             current =iv_ruleStepNumber.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStepNumber"


    // $ANTLR start "ruleStepNumber"
    // InternalUcm4iot.g:2404:1: ruleStepNumber returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_MainStepNumber_0= ruleMainStepNumber | this_ExtensionStepNumber_1= ruleExtensionStepNumber ) ;
    public final AntlrDatatypeRuleToken ruleStepNumber() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_MainStepNumber_0 = null;

        AntlrDatatypeRuleToken this_ExtensionStepNumber_1 = null;



        	enterRule();

        try {
            // InternalUcm4iot.g:2410:2: ( (this_MainStepNumber_0= ruleMainStepNumber | this_ExtensionStepNumber_1= ruleExtensionStepNumber ) )
            // InternalUcm4iot.g:2411:2: (this_MainStepNumber_0= ruleMainStepNumber | this_ExtensionStepNumber_1= ruleExtensionStepNumber )
            {
            // InternalUcm4iot.g:2411:2: (this_MainStepNumber_0= ruleMainStepNumber | this_ExtensionStepNumber_1= ruleExtensionStepNumber )
            int alt44=2;
            alt44 = dfa44.predict(input);
            switch (alt44) {
                case 1 :
                    // InternalUcm4iot.g:2412:3: this_MainStepNumber_0= ruleMainStepNumber
                    {

                    			newCompositeNode(grammarAccess.getStepNumberAccess().getMainStepNumberParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_MainStepNumber_0=ruleMainStepNumber();

                    state._fsp--;


                    			current.merge(this_MainStepNumber_0);
                    		

                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:2423:3: this_ExtensionStepNumber_1= ruleExtensionStepNumber
                    {

                    			newCompositeNode(grammarAccess.getStepNumberAccess().getExtensionStepNumberParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ExtensionStepNumber_1=ruleExtensionStepNumber();

                    state._fsp--;


                    			current.merge(this_ExtensionStepNumber_1);
                    		

                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStepNumber"


    // $ANTLR start "entryRuleGroupedSteps"
    // InternalUcm4iot.g:2437:1: entryRuleGroupedSteps returns [String current=null] : iv_ruleGroupedSteps= ruleGroupedSteps EOF ;
    public final String entryRuleGroupedSteps() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleGroupedSteps = null;


        try {
            // InternalUcm4iot.g:2437:52: (iv_ruleGroupedSteps= ruleGroupedSteps EOF )
            // InternalUcm4iot.g:2438:2: iv_ruleGroupedSteps= ruleGroupedSteps EOF
            {
             newCompositeNode(grammarAccess.getGroupedStepsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGroupedSteps=ruleGroupedSteps();

            state._fsp--;

             current =iv_ruleGroupedSteps.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGroupedSteps"


    // $ANTLR start "ruleGroupedSteps"
    // InternalUcm4iot.g:2444:1: ruleGroupedSteps returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '(' this_MainStepNumber_1= ruleMainStepNumber kw= '-' this_MainStepNumber_3= ruleMainStepNumber kw= ')' ) ;
    public final AntlrDatatypeRuleToken ruleGroupedSteps() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_MainStepNumber_1 = null;

        AntlrDatatypeRuleToken this_MainStepNumber_3 = null;



        	enterRule();

        try {
            // InternalUcm4iot.g:2450:2: ( (kw= '(' this_MainStepNumber_1= ruleMainStepNumber kw= '-' this_MainStepNumber_3= ruleMainStepNumber kw= ')' ) )
            // InternalUcm4iot.g:2451:2: (kw= '(' this_MainStepNumber_1= ruleMainStepNumber kw= '-' this_MainStepNumber_3= ruleMainStepNumber kw= ')' )
            {
            // InternalUcm4iot.g:2451:2: (kw= '(' this_MainStepNumber_1= ruleMainStepNumber kw= '-' this_MainStepNumber_3= ruleMainStepNumber kw= ')' )
            // InternalUcm4iot.g:2452:3: kw= '(' this_MainStepNumber_1= ruleMainStepNumber kw= '-' this_MainStepNumber_3= ruleMainStepNumber kw= ')'
            {
            kw=(Token)match(input,18,FOLLOW_37); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getGroupedStepsAccess().getLeftParenthesisKeyword_0());
            		

            			newCompositeNode(grammarAccess.getGroupedStepsAccess().getMainStepNumberParserRuleCall_1());
            		
            pushFollow(FOLLOW_27);
            this_MainStepNumber_1=ruleMainStepNumber();

            state._fsp--;


            			current.merge(this_MainStepNumber_1);
            		

            			afterParserOrEnumRuleCall();
            		
            kw=(Token)match(input,19,FOLLOW_37); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getGroupedStepsAccess().getHyphenMinusKeyword_2());
            		

            			newCompositeNode(grammarAccess.getGroupedStepsAccess().getMainStepNumberParserRuleCall_3());
            		
            pushFollow(FOLLOW_28);
            this_MainStepNumber_3=ruleMainStepNumber();

            state._fsp--;


            			current.merge(this_MainStepNumber_3);
            		

            			afterParserOrEnumRuleCall();
            		
            kw=(Token)match(input,20,FOLLOW_2); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getGroupedStepsAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGroupedSteps"


    // $ANTLR start "entryRuleMainStepNumber"
    // InternalUcm4iot.g:2491:1: entryRuleMainStepNumber returns [String current=null] : iv_ruleMainStepNumber= ruleMainStepNumber EOF ;
    public final String entryRuleMainStepNumber() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMainStepNumber = null;


        try {
            // InternalUcm4iot.g:2491:54: (iv_ruleMainStepNumber= ruleMainStepNumber EOF )
            // InternalUcm4iot.g:2492:2: iv_ruleMainStepNumber= ruleMainStepNumber EOF
            {
             newCompositeNode(grammarAccess.getMainStepNumberRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMainStepNumber=ruleMainStepNumber();

            state._fsp--;

             current =iv_ruleMainStepNumber.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMainStepNumber"


    // $ANTLR start "ruleMainStepNumber"
    // InternalUcm4iot.g:2498:1: ruleMainStepNumber returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ) ;
    public final AntlrDatatypeRuleToken ruleMainStepNumber() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;


        	enterRule();

        try {
            // InternalUcm4iot.g:2504:2: ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ) )
            // InternalUcm4iot.g:2505:2: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* )
            {
            // InternalUcm4iot.g:2505:2: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* )
            // InternalUcm4iot.g:2506:3: this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )*
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_38); 

            			current.merge(this_INT_0);
            		

            			newLeafNode(this_INT_0, grammarAccess.getMainStepNumberAccess().getINTTerminalRuleCall_0());
            		
            // InternalUcm4iot.g:2513:3: (kw= '.' this_INT_2= RULE_INT )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==21) ) {
                    int LA45_2 = input.LA(2);

                    if ( (LA45_2==RULE_INT) ) {
                        alt45=1;
                    }


                }


                switch (alt45) {
            	case 1 :
            	    // InternalUcm4iot.g:2514:4: kw= '.' this_INT_2= RULE_INT
            	    {
            	    kw=(Token)match(input,21,FOLLOW_37); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getMainStepNumberAccess().getFullStopKeyword_1_0());
            	    			
            	    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_38); 

            	    				current.merge(this_INT_2);
            	    			

            	    				newLeafNode(this_INT_2, grammarAccess.getMainStepNumberAccess().getINTTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMainStepNumber"


    // $ANTLR start "entryRuleExtensionStepNumber"
    // InternalUcm4iot.g:2531:1: entryRuleExtensionStepNumber returns [String current=null] : iv_ruleExtensionStepNumber= ruleExtensionStepNumber EOF ;
    public final String entryRuleExtensionStepNumber() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExtensionStepNumber = null;


        try {
            // InternalUcm4iot.g:2531:59: (iv_ruleExtensionStepNumber= ruleExtensionStepNumber EOF )
            // InternalUcm4iot.g:2532:2: iv_ruleExtensionStepNumber= ruleExtensionStepNumber EOF
            {
             newCompositeNode(grammarAccess.getExtensionStepNumberRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExtensionStepNumber=ruleExtensionStepNumber();

            state._fsp--;

             current =iv_ruleExtensionStepNumber.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExtensionStepNumber"


    // $ANTLR start "ruleExtensionStepNumber"
    // InternalUcm4iot.g:2538:1: ruleExtensionStepNumber returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_MainStepNumber_0= ruleMainStepNumber | this_GroupedSteps_1= ruleGroupedSteps ) this_ID_2= RULE_ID (kw= '.' this_INT_4= RULE_INT (this_ID_5= RULE_ID )? )* ) ;
    public final AntlrDatatypeRuleToken ruleExtensionStepNumber() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_2=null;
        Token kw=null;
        Token this_INT_4=null;
        Token this_ID_5=null;
        AntlrDatatypeRuleToken this_MainStepNumber_0 = null;

        AntlrDatatypeRuleToken this_GroupedSteps_1 = null;



        	enterRule();

        try {
            // InternalUcm4iot.g:2544:2: ( ( (this_MainStepNumber_0= ruleMainStepNumber | this_GroupedSteps_1= ruleGroupedSteps ) this_ID_2= RULE_ID (kw= '.' this_INT_4= RULE_INT (this_ID_5= RULE_ID )? )* ) )
            // InternalUcm4iot.g:2545:2: ( (this_MainStepNumber_0= ruleMainStepNumber | this_GroupedSteps_1= ruleGroupedSteps ) this_ID_2= RULE_ID (kw= '.' this_INT_4= RULE_INT (this_ID_5= RULE_ID )? )* )
            {
            // InternalUcm4iot.g:2545:2: ( (this_MainStepNumber_0= ruleMainStepNumber | this_GroupedSteps_1= ruleGroupedSteps ) this_ID_2= RULE_ID (kw= '.' this_INT_4= RULE_INT (this_ID_5= RULE_ID )? )* )
            // InternalUcm4iot.g:2546:3: (this_MainStepNumber_0= ruleMainStepNumber | this_GroupedSteps_1= ruleGroupedSteps ) this_ID_2= RULE_ID (kw= '.' this_INT_4= RULE_INT (this_ID_5= RULE_ID )? )*
            {
            // InternalUcm4iot.g:2546:3: (this_MainStepNumber_0= ruleMainStepNumber | this_GroupedSteps_1= ruleGroupedSteps )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==RULE_INT) ) {
                alt46=1;
            }
            else if ( (LA46_0==18) ) {
                alt46=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // InternalUcm4iot.g:2547:4: this_MainStepNumber_0= ruleMainStepNumber
                    {

                    				newCompositeNode(grammarAccess.getExtensionStepNumberAccess().getMainStepNumberParserRuleCall_0_0());
                    			
                    pushFollow(FOLLOW_11);
                    this_MainStepNumber_0=ruleMainStepNumber();

                    state._fsp--;


                    				current.merge(this_MainStepNumber_0);
                    			

                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:2558:4: this_GroupedSteps_1= ruleGroupedSteps
                    {

                    				newCompositeNode(grammarAccess.getExtensionStepNumberAccess().getGroupedStepsParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_11);
                    this_GroupedSteps_1=ruleGroupedSteps();

                    state._fsp--;


                    				current.merge(this_GroupedSteps_1);
                    			

                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_38); 

            			current.merge(this_ID_2);
            		

            			newLeafNode(this_ID_2, grammarAccess.getExtensionStepNumberAccess().getIDTerminalRuleCall_1());
            		
            // InternalUcm4iot.g:2576:3: (kw= '.' this_INT_4= RULE_INT (this_ID_5= RULE_ID )? )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==21) ) {
                    int LA48_2 = input.LA(2);

                    if ( (LA48_2==RULE_INT) ) {
                        alt48=1;
                    }


                }


                switch (alt48) {
            	case 1 :
            	    // InternalUcm4iot.g:2577:4: kw= '.' this_INT_4= RULE_INT (this_ID_5= RULE_ID )?
            	    {
            	    kw=(Token)match(input,21,FOLLOW_37); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getExtensionStepNumberAccess().getFullStopKeyword_2_0());
            	    			
            	    this_INT_4=(Token)match(input,RULE_INT,FOLLOW_39); 

            	    				current.merge(this_INT_4);
            	    			

            	    				newLeafNode(this_INT_4, grammarAccess.getExtensionStepNumberAccess().getINTTerminalRuleCall_2_1());
            	    			
            	    // InternalUcm4iot.g:2589:4: (this_ID_5= RULE_ID )?
            	    int alt47=2;
            	    int LA47_0 = input.LA(1);

            	    if ( (LA47_0==RULE_ID) ) {
            	        alt47=1;
            	    }
            	    switch (alt47) {
            	        case 1 :
            	            // InternalUcm4iot.g:2590:5: this_ID_5= RULE_ID
            	            {
            	            this_ID_5=(Token)match(input,RULE_ID,FOLLOW_38); 

            	            					current.merge(this_ID_5);
            	            				

            	            					newLeafNode(this_ID_5, grammarAccess.getExtensionStepNumberAccess().getIDTerminalRuleCall_2_2());
            	            				

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExtensionStepNumber"


    // $ANTLR start "entryRuleException"
    // InternalUcm4iot.g:2603:1: entryRuleException returns [EObject current=null] : iv_ruleException= ruleException EOF ;
    public final EObject entryRuleException() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleException = null;


        try {
            // InternalUcm4iot.g:2603:50: (iv_ruleException= ruleException EOF )
            // InternalUcm4iot.g:2604:2: iv_ruleException= ruleException EOF
            {
             newCompositeNode(grammarAccess.getExceptionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleException=ruleException();

            state._fsp--;

             current =iv_ruleException; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleException"


    // $ANTLR start "ruleException"
    // InternalUcm4iot.g:2610:1: ruleException returns [EObject current=null] : (this_EnvironmentException_0= ruleEnvironmentException | this_NetworkException_1= ruleNetworkException | this_HardwareException_2= ruleHardwareException | this_SoftwareException_3= ruleSoftwareException ) ;
    public final EObject ruleException() throws RecognitionException {
        EObject current = null;

        EObject this_EnvironmentException_0 = null;

        EObject this_NetworkException_1 = null;

        EObject this_HardwareException_2 = null;

        EObject this_SoftwareException_3 = null;



        	enterRule();

        try {
            // InternalUcm4iot.g:2616:2: ( (this_EnvironmentException_0= ruleEnvironmentException | this_NetworkException_1= ruleNetworkException | this_HardwareException_2= ruleHardwareException | this_SoftwareException_3= ruleSoftwareException ) )
            // InternalUcm4iot.g:2617:2: (this_EnvironmentException_0= ruleEnvironmentException | this_NetworkException_1= ruleNetworkException | this_HardwareException_2= ruleHardwareException | this_SoftwareException_3= ruleSoftwareException )
            {
            // InternalUcm4iot.g:2617:2: (this_EnvironmentException_0= ruleEnvironmentException | this_NetworkException_1= ruleNetworkException | this_HardwareException_2= ruleHardwareException | this_SoftwareException_3= ruleSoftwareException )
            int alt49=4;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==24) ) {
                switch ( input.LA(2) ) {
                case 93:
                    {
                    alt49=4;
                    }
                    break;
                case 92:
                    {
                    alt49=3;
                    }
                    break;
                case 91:
                    {
                    alt49=2;
                    }
                    break;
                case 90:
                    {
                    alt49=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 49, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // InternalUcm4iot.g:2618:3: this_EnvironmentException_0= ruleEnvironmentException
                    {

                    			newCompositeNode(grammarAccess.getExceptionAccess().getEnvironmentExceptionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_EnvironmentException_0=ruleEnvironmentException();

                    state._fsp--;


                    			current = this_EnvironmentException_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:2627:3: this_NetworkException_1= ruleNetworkException
                    {

                    			newCompositeNode(grammarAccess.getExceptionAccess().getNetworkExceptionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_NetworkException_1=ruleNetworkException();

                    state._fsp--;


                    			current = this_NetworkException_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalUcm4iot.g:2636:3: this_HardwareException_2= ruleHardwareException
                    {

                    			newCompositeNode(grammarAccess.getExceptionAccess().getHardwareExceptionParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_HardwareException_2=ruleHardwareException();

                    state._fsp--;


                    			current = this_HardwareException_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalUcm4iot.g:2645:3: this_SoftwareException_3= ruleSoftwareException
                    {

                    			newCompositeNode(grammarAccess.getExceptionAccess().getSoftwareExceptionParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_SoftwareException_3=ruleSoftwareException();

                    state._fsp--;


                    			current = this_SoftwareException_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleException"


    // $ANTLR start "entryRuleEnvironmentException"
    // InternalUcm4iot.g:2657:1: entryRuleEnvironmentException returns [EObject current=null] : iv_ruleEnvironmentException= ruleEnvironmentException EOF ;
    public final EObject entryRuleEnvironmentException() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnvironmentException = null;


        try {
            // InternalUcm4iot.g:2657:61: (iv_ruleEnvironmentException= ruleEnvironmentException EOF )
            // InternalUcm4iot.g:2658:2: iv_ruleEnvironmentException= ruleEnvironmentException EOF
            {
             newCompositeNode(grammarAccess.getEnvironmentExceptionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnvironmentException=ruleEnvironmentException();

            state._fsp--;

             current =iv_ruleEnvironmentException; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnvironmentException"


    // $ANTLR start "ruleEnvironmentException"
    // InternalUcm4iot.g:2664:1: ruleEnvironmentException returns [EObject current=null] : (otherlv_0= '{' ruleKeywordEnvironmentException otherlv_2= '::' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '}' ) ;
    public final EObject ruleEnvironmentException() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalUcm4iot.g:2670:2: ( (otherlv_0= '{' ruleKeywordEnvironmentException otherlv_2= '::' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '}' ) )
            // InternalUcm4iot.g:2671:2: (otherlv_0= '{' ruleKeywordEnvironmentException otherlv_2= '::' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '}' )
            {
            // InternalUcm4iot.g:2671:2: (otherlv_0= '{' ruleKeywordEnvironmentException otherlv_2= '::' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '}' )
            // InternalUcm4iot.g:2672:3: otherlv_0= '{' ruleKeywordEnvironmentException otherlv_2= '::' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_40); 

            			newLeafNode(otherlv_0, grammarAccess.getEnvironmentExceptionAccess().getLeftCurlyBracketKeyword_0());
            		

            			newCompositeNode(grammarAccess.getEnvironmentExceptionAccess().getKeywordEnvironmentExceptionParserRuleCall_1());
            		
            pushFollow(FOLLOW_41);
            ruleKeywordEnvironmentException();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		
            otherlv_2=(Token)match(input,25,FOLLOW_11); 

            			newLeafNode(otherlv_2, grammarAccess.getEnvironmentExceptionAccess().getColonColonKeyword_2());
            		
            // InternalUcm4iot.g:2687:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalUcm4iot.g:2688:4: (lv_name_3_0= RULE_ID )
            {
            // InternalUcm4iot.g:2688:4: (lv_name_3_0= RULE_ID )
            // InternalUcm4iot.g:2689:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_42); 

            					newLeafNode(lv_name_3_0, grammarAccess.getEnvironmentExceptionAccess().getNameIDTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEnvironmentExceptionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_4=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getEnvironmentExceptionAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnvironmentException"


    // $ANTLR start "entryRuleNetworkException"
    // InternalUcm4iot.g:2713:1: entryRuleNetworkException returns [EObject current=null] : iv_ruleNetworkException= ruleNetworkException EOF ;
    public final EObject entryRuleNetworkException() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNetworkException = null;


        try {
            // InternalUcm4iot.g:2713:57: (iv_ruleNetworkException= ruleNetworkException EOF )
            // InternalUcm4iot.g:2714:2: iv_ruleNetworkException= ruleNetworkException EOF
            {
             newCompositeNode(grammarAccess.getNetworkExceptionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNetworkException=ruleNetworkException();

            state._fsp--;

             current =iv_ruleNetworkException; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNetworkException"


    // $ANTLR start "ruleNetworkException"
    // InternalUcm4iot.g:2720:1: ruleNetworkException returns [EObject current=null] : (otherlv_0= '{' ruleKeywordNetworkException otherlv_2= '::' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '}' ) ;
    public final EObject ruleNetworkException() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalUcm4iot.g:2726:2: ( (otherlv_0= '{' ruleKeywordNetworkException otherlv_2= '::' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '}' ) )
            // InternalUcm4iot.g:2727:2: (otherlv_0= '{' ruleKeywordNetworkException otherlv_2= '::' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '}' )
            {
            // InternalUcm4iot.g:2727:2: (otherlv_0= '{' ruleKeywordNetworkException otherlv_2= '::' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '}' )
            // InternalUcm4iot.g:2728:3: otherlv_0= '{' ruleKeywordNetworkException otherlv_2= '::' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_43); 

            			newLeafNode(otherlv_0, grammarAccess.getNetworkExceptionAccess().getLeftCurlyBracketKeyword_0());
            		

            			newCompositeNode(grammarAccess.getNetworkExceptionAccess().getKeywordNetworkExceptionParserRuleCall_1());
            		
            pushFollow(FOLLOW_41);
            ruleKeywordNetworkException();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		
            otherlv_2=(Token)match(input,25,FOLLOW_11); 

            			newLeafNode(otherlv_2, grammarAccess.getNetworkExceptionAccess().getColonColonKeyword_2());
            		
            // InternalUcm4iot.g:2743:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalUcm4iot.g:2744:4: (lv_name_3_0= RULE_ID )
            {
            // InternalUcm4iot.g:2744:4: (lv_name_3_0= RULE_ID )
            // InternalUcm4iot.g:2745:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_42); 

            					newLeafNode(lv_name_3_0, grammarAccess.getNetworkExceptionAccess().getNameIDTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getNetworkExceptionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_4=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getNetworkExceptionAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNetworkException"


    // $ANTLR start "entryRuleHardwareException"
    // InternalUcm4iot.g:2769:1: entryRuleHardwareException returns [EObject current=null] : iv_ruleHardwareException= ruleHardwareException EOF ;
    public final EObject entryRuleHardwareException() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHardwareException = null;


        try {
            // InternalUcm4iot.g:2769:58: (iv_ruleHardwareException= ruleHardwareException EOF )
            // InternalUcm4iot.g:2770:2: iv_ruleHardwareException= ruleHardwareException EOF
            {
             newCompositeNode(grammarAccess.getHardwareExceptionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleHardwareException=ruleHardwareException();

            state._fsp--;

             current =iv_ruleHardwareException; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHardwareException"


    // $ANTLR start "ruleHardwareException"
    // InternalUcm4iot.g:2776:1: ruleHardwareException returns [EObject current=null] : (otherlv_0= '{' ruleKeywordHardwareException otherlv_2= '::' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '}' ) ;
    public final EObject ruleHardwareException() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalUcm4iot.g:2782:2: ( (otherlv_0= '{' ruleKeywordHardwareException otherlv_2= '::' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '}' ) )
            // InternalUcm4iot.g:2783:2: (otherlv_0= '{' ruleKeywordHardwareException otherlv_2= '::' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '}' )
            {
            // InternalUcm4iot.g:2783:2: (otherlv_0= '{' ruleKeywordHardwareException otherlv_2= '::' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '}' )
            // InternalUcm4iot.g:2784:3: otherlv_0= '{' ruleKeywordHardwareException otherlv_2= '::' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_44); 

            			newLeafNode(otherlv_0, grammarAccess.getHardwareExceptionAccess().getLeftCurlyBracketKeyword_0());
            		

            			newCompositeNode(grammarAccess.getHardwareExceptionAccess().getKeywordHardwareExceptionParserRuleCall_1());
            		
            pushFollow(FOLLOW_41);
            ruleKeywordHardwareException();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		
            otherlv_2=(Token)match(input,25,FOLLOW_11); 

            			newLeafNode(otherlv_2, grammarAccess.getHardwareExceptionAccess().getColonColonKeyword_2());
            		
            // InternalUcm4iot.g:2799:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalUcm4iot.g:2800:4: (lv_name_3_0= RULE_ID )
            {
            // InternalUcm4iot.g:2800:4: (lv_name_3_0= RULE_ID )
            // InternalUcm4iot.g:2801:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_42); 

            					newLeafNode(lv_name_3_0, grammarAccess.getHardwareExceptionAccess().getNameIDTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHardwareExceptionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_4=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getHardwareExceptionAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHardwareException"


    // $ANTLR start "entryRuleSoftwareException"
    // InternalUcm4iot.g:2825:1: entryRuleSoftwareException returns [EObject current=null] : iv_ruleSoftwareException= ruleSoftwareException EOF ;
    public final EObject entryRuleSoftwareException() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSoftwareException = null;


        try {
            // InternalUcm4iot.g:2825:58: (iv_ruleSoftwareException= ruleSoftwareException EOF )
            // InternalUcm4iot.g:2826:2: iv_ruleSoftwareException= ruleSoftwareException EOF
            {
             newCompositeNode(grammarAccess.getSoftwareExceptionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSoftwareException=ruleSoftwareException();

            state._fsp--;

             current =iv_ruleSoftwareException; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSoftwareException"


    // $ANTLR start "ruleSoftwareException"
    // InternalUcm4iot.g:2832:1: ruleSoftwareException returns [EObject current=null] : (otherlv_0= '{' ruleKeywordSoftwareException otherlv_2= '::' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '}' ) ;
    public final EObject ruleSoftwareException() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalUcm4iot.g:2838:2: ( (otherlv_0= '{' ruleKeywordSoftwareException otherlv_2= '::' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '}' ) )
            // InternalUcm4iot.g:2839:2: (otherlv_0= '{' ruleKeywordSoftwareException otherlv_2= '::' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '}' )
            {
            // InternalUcm4iot.g:2839:2: (otherlv_0= '{' ruleKeywordSoftwareException otherlv_2= '::' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '}' )
            // InternalUcm4iot.g:2840:3: otherlv_0= '{' ruleKeywordSoftwareException otherlv_2= '::' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_45); 

            			newLeafNode(otherlv_0, grammarAccess.getSoftwareExceptionAccess().getLeftCurlyBracketKeyword_0());
            		

            			newCompositeNode(grammarAccess.getSoftwareExceptionAccess().getKeywordSoftwareExceptionParserRuleCall_1());
            		
            pushFollow(FOLLOW_41);
            ruleKeywordSoftwareException();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		
            otherlv_2=(Token)match(input,25,FOLLOW_11); 

            			newLeafNode(otherlv_2, grammarAccess.getSoftwareExceptionAccess().getColonColonKeyword_2());
            		
            // InternalUcm4iot.g:2855:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalUcm4iot.g:2856:4: (lv_name_3_0= RULE_ID )
            {
            // InternalUcm4iot.g:2856:4: (lv_name_3_0= RULE_ID )
            // InternalUcm4iot.g:2857:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_42); 

            					newLeafNode(lv_name_3_0, grammarAccess.getSoftwareExceptionAccess().getNameIDTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSoftwareExceptionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_4=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getSoftwareExceptionAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSoftwareException"


    // $ANTLR start "entryRuleContextExceptionMapping"
    // InternalUcm4iot.g:2881:1: entryRuleContextExceptionMapping returns [EObject current=null] : iv_ruleContextExceptionMapping= ruleContextExceptionMapping EOF ;
    public final EObject entryRuleContextExceptionMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContextExceptionMapping = null;


        try {
            // InternalUcm4iot.g:2881:64: (iv_ruleContextExceptionMapping= ruleContextExceptionMapping EOF )
            // InternalUcm4iot.g:2882:2: iv_ruleContextExceptionMapping= ruleContextExceptionMapping EOF
            {
             newCompositeNode(grammarAccess.getContextExceptionMappingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContextExceptionMapping=ruleContextExceptionMapping();

            state._fsp--;

             current =iv_ruleContextExceptionMapping; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContextExceptionMapping"


    // $ANTLR start "ruleContextExceptionMapping"
    // InternalUcm4iot.g:2888:1: ruleContextExceptionMapping returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '{' ruleKeywordException otherlv_3= '::' ( (otherlv_4= RULE_ID ) ) otherlv_5= '}' ) ;
    public final EObject ruleContextExceptionMapping() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalUcm4iot.g:2894:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '{' ruleKeywordException otherlv_3= '::' ( (otherlv_4= RULE_ID ) ) otherlv_5= '}' ) )
            // InternalUcm4iot.g:2895:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '{' ruleKeywordException otherlv_3= '::' ( (otherlv_4= RULE_ID ) ) otherlv_5= '}' )
            {
            // InternalUcm4iot.g:2895:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '{' ruleKeywordException otherlv_3= '::' ( (otherlv_4= RULE_ID ) ) otherlv_5= '}' )
            // InternalUcm4iot.g:2896:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '{' ruleKeywordException otherlv_3= '::' ( (otherlv_4= RULE_ID ) ) otherlv_5= '}'
            {
            // InternalUcm4iot.g:2896:3: ( (otherlv_0= RULE_ID ) )
            // InternalUcm4iot.g:2897:4: (otherlv_0= RULE_ID )
            {
            // InternalUcm4iot.g:2897:4: (otherlv_0= RULE_ID )
            // InternalUcm4iot.g:2898:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getContextExceptionMappingRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_46); 

            					newLeafNode(otherlv_0, grammarAccess.getContextExceptionMappingAccess().getContextUseCaseCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,24,FOLLOW_47); 

            			newLeafNode(otherlv_1, grammarAccess.getContextExceptionMappingAccess().getLeftCurlyBracketKeyword_1());
            		

            			newCompositeNode(grammarAccess.getContextExceptionMappingAccess().getKeywordExceptionParserRuleCall_2());
            		
            pushFollow(FOLLOW_41);
            ruleKeywordException();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		
            otherlv_3=(Token)match(input,25,FOLLOW_11); 

            			newLeafNode(otherlv_3, grammarAccess.getContextExceptionMappingAccess().getColonColonKeyword_3());
            		
            // InternalUcm4iot.g:2924:3: ( (otherlv_4= RULE_ID ) )
            // InternalUcm4iot.g:2925:4: (otherlv_4= RULE_ID )
            {
            // InternalUcm4iot.g:2925:4: (otherlv_4= RULE_ID )
            // InternalUcm4iot.g:2926:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getContextExceptionMappingRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_42); 

            					newLeafNode(otherlv_4, grammarAccess.getContextExceptionMappingAccess().getExceptionExceptionCrossReference_4_0());
            				

            }


            }

            otherlv_5=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getContextExceptionMappingAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContextExceptionMapping"


    // $ANTLR start "entryRulePrimaryActor"
    // InternalUcm4iot.g:2945:1: entryRulePrimaryActor returns [EObject current=null] : iv_rulePrimaryActor= rulePrimaryActor EOF ;
    public final EObject entryRulePrimaryActor() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryActor = null;


        try {
            // InternalUcm4iot.g:2945:53: (iv_rulePrimaryActor= rulePrimaryActor EOF )
            // InternalUcm4iot.g:2946:2: iv_rulePrimaryActor= rulePrimaryActor EOF
            {
             newCompositeNode(grammarAccess.getPrimaryActorRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimaryActor=rulePrimaryActor();

            state._fsp--;

             current =iv_rulePrimaryActor; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimaryActor"


    // $ANTLR start "rulePrimaryActor"
    // InternalUcm4iot.g:2952:1: rulePrimaryActor returns [EObject current=null] : (this_HumanActor_0= ruleHumanActor | this_SoftwareActor_1= ruleSoftwareActor | ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject rulePrimaryActor() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        EObject this_HumanActor_0 = null;

        EObject this_SoftwareActor_1 = null;



        	enterRule();

        try {
            // InternalUcm4iot.g:2958:2: ( (this_HumanActor_0= ruleHumanActor | this_SoftwareActor_1= ruleSoftwareActor | ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalUcm4iot.g:2959:2: (this_HumanActor_0= ruleHumanActor | this_SoftwareActor_1= ruleSoftwareActor | ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalUcm4iot.g:2959:2: (this_HumanActor_0= ruleHumanActor | this_SoftwareActor_1= ruleSoftwareActor | ( (lv_name_2_0= RULE_ID ) ) )
            int alt50=3;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt50=1;
                }
                break;
            case 28:
                {
                alt50=2;
                }
                break;
            case RULE_ID:
                {
                alt50=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }

            switch (alt50) {
                case 1 :
                    // InternalUcm4iot.g:2960:3: this_HumanActor_0= ruleHumanActor
                    {

                    			newCompositeNode(grammarAccess.getPrimaryActorAccess().getHumanActorParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_HumanActor_0=ruleHumanActor();

                    state._fsp--;


                    			current = this_HumanActor_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:2969:3: this_SoftwareActor_1= ruleSoftwareActor
                    {

                    			newCompositeNode(grammarAccess.getPrimaryActorAccess().getSoftwareActorParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_SoftwareActor_1=ruleSoftwareActor();

                    state._fsp--;


                    			current = this_SoftwareActor_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalUcm4iot.g:2978:3: ( (lv_name_2_0= RULE_ID ) )
                    {
                    // InternalUcm4iot.g:2978:3: ( (lv_name_2_0= RULE_ID ) )
                    // InternalUcm4iot.g:2979:4: (lv_name_2_0= RULE_ID )
                    {
                    // InternalUcm4iot.g:2979:4: (lv_name_2_0= RULE_ID )
                    // InternalUcm4iot.g:2980:5: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    					newLeafNode(lv_name_2_0, grammarAccess.getPrimaryActorAccess().getNameIDTerminalRuleCall_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getPrimaryActorRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"name",
                    						lv_name_2_0,
                    						"org.eclipse.xtext.common.Terminals.ID");
                    				

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimaryActor"


    // $ANTLR start "entryRuleSecondaryActor"
    // InternalUcm4iot.g:3000:1: entryRuleSecondaryActor returns [EObject current=null] : iv_ruleSecondaryActor= ruleSecondaryActor EOF ;
    public final EObject entryRuleSecondaryActor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSecondaryActor = null;


        try {
            // InternalUcm4iot.g:3000:55: (iv_ruleSecondaryActor= ruleSecondaryActor EOF )
            // InternalUcm4iot.g:3001:2: iv_ruleSecondaryActor= ruleSecondaryActor EOF
            {
             newCompositeNode(grammarAccess.getSecondaryActorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSecondaryActor=ruleSecondaryActor();

            state._fsp--;

             current =iv_ruleSecondaryActor; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSecondaryActor"


    // $ANTLR start "ruleSecondaryActor"
    // InternalUcm4iot.g:3007:1: ruleSecondaryActor returns [EObject current=null] : (this_HumanActor_0= ruleHumanActor | this_SoftwareActor_1= ruleSoftwareActor | this_DeviceActor_2= ruleDeviceActor | this_PhysicalEntityActor_3= rulePhysicalEntityActor | ( (lv_name_4_0= RULE_ID ) ) ) ;
    public final EObject ruleSecondaryActor() throws RecognitionException {
        EObject current = null;

        Token lv_name_4_0=null;
        EObject this_HumanActor_0 = null;

        EObject this_SoftwareActor_1 = null;

        EObject this_DeviceActor_2 = null;

        EObject this_PhysicalEntityActor_3 = null;



        	enterRule();

        try {
            // InternalUcm4iot.g:3013:2: ( (this_HumanActor_0= ruleHumanActor | this_SoftwareActor_1= ruleSoftwareActor | this_DeviceActor_2= ruleDeviceActor | this_PhysicalEntityActor_3= rulePhysicalEntityActor | ( (lv_name_4_0= RULE_ID ) ) ) )
            // InternalUcm4iot.g:3014:2: (this_HumanActor_0= ruleHumanActor | this_SoftwareActor_1= ruleSoftwareActor | this_DeviceActor_2= ruleDeviceActor | this_PhysicalEntityActor_3= rulePhysicalEntityActor | ( (lv_name_4_0= RULE_ID ) ) )
            {
            // InternalUcm4iot.g:3014:2: (this_HumanActor_0= ruleHumanActor | this_SoftwareActor_1= ruleSoftwareActor | this_DeviceActor_2= ruleDeviceActor | this_PhysicalEntityActor_3= rulePhysicalEntityActor | ( (lv_name_4_0= RULE_ID ) ) )
            int alt51=5;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt51=1;
                }
                break;
            case 28:
                {
                alt51=2;
                }
                break;
            case 29:
            case 30:
            case 31:
            case 32:
                {
                alt51=3;
                }
                break;
            case 33:
                {
                alt51=4;
                }
                break;
            case RULE_ID:
                {
                alt51=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }

            switch (alt51) {
                case 1 :
                    // InternalUcm4iot.g:3015:3: this_HumanActor_0= ruleHumanActor
                    {

                    			newCompositeNode(grammarAccess.getSecondaryActorAccess().getHumanActorParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_HumanActor_0=ruleHumanActor();

                    state._fsp--;


                    			current = this_HumanActor_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:3024:3: this_SoftwareActor_1= ruleSoftwareActor
                    {

                    			newCompositeNode(grammarAccess.getSecondaryActorAccess().getSoftwareActorParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_SoftwareActor_1=ruleSoftwareActor();

                    state._fsp--;


                    			current = this_SoftwareActor_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalUcm4iot.g:3033:3: this_DeviceActor_2= ruleDeviceActor
                    {

                    			newCompositeNode(grammarAccess.getSecondaryActorAccess().getDeviceActorParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_DeviceActor_2=ruleDeviceActor();

                    state._fsp--;


                    			current = this_DeviceActor_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalUcm4iot.g:3042:3: this_PhysicalEntityActor_3= rulePhysicalEntityActor
                    {

                    			newCompositeNode(grammarAccess.getSecondaryActorAccess().getPhysicalEntityActorParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_PhysicalEntityActor_3=rulePhysicalEntityActor();

                    state._fsp--;


                    			current = this_PhysicalEntityActor_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalUcm4iot.g:3051:3: ( (lv_name_4_0= RULE_ID ) )
                    {
                    // InternalUcm4iot.g:3051:3: ( (lv_name_4_0= RULE_ID ) )
                    // InternalUcm4iot.g:3052:4: (lv_name_4_0= RULE_ID )
                    {
                    // InternalUcm4iot.g:3052:4: (lv_name_4_0= RULE_ID )
                    // InternalUcm4iot.g:3053:5: lv_name_4_0= RULE_ID
                    {
                    lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    					newLeafNode(lv_name_4_0, grammarAccess.getSecondaryActorAccess().getNameIDTerminalRuleCall_4_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getSecondaryActorRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"name",
                    						lv_name_4_0,
                    						"org.eclipse.xtext.common.Terminals.ID");
                    				

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSecondaryActor"


    // $ANTLR start "entryRuleHumanActor"
    // InternalUcm4iot.g:3073:1: entryRuleHumanActor returns [EObject current=null] : iv_ruleHumanActor= ruleHumanActor EOF ;
    public final EObject entryRuleHumanActor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHumanActor = null;


        try {
            // InternalUcm4iot.g:3073:51: (iv_ruleHumanActor= ruleHumanActor EOF )
            // InternalUcm4iot.g:3074:2: iv_ruleHumanActor= ruleHumanActor EOF
            {
             newCompositeNode(grammarAccess.getHumanActorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleHumanActor=ruleHumanActor();

            state._fsp--;

             current =iv_ruleHumanActor; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHumanActor"


    // $ANTLR start "ruleHumanActor"
    // InternalUcm4iot.g:3080:1: ruleHumanActor returns [EObject current=null] : (otherlv_0= 'HUMAN' otherlv_1= '::' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleHumanActor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;


        	enterRule();

        try {
            // InternalUcm4iot.g:3086:2: ( (otherlv_0= 'HUMAN' otherlv_1= '::' ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalUcm4iot.g:3087:2: (otherlv_0= 'HUMAN' otherlv_1= '::' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalUcm4iot.g:3087:2: (otherlv_0= 'HUMAN' otherlv_1= '::' ( (lv_name_2_0= RULE_ID ) ) )
            // InternalUcm4iot.g:3088:3: otherlv_0= 'HUMAN' otherlv_1= '::' ( (lv_name_2_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,27,FOLLOW_41); 

            			newLeafNode(otherlv_0, grammarAccess.getHumanActorAccess().getHUMANKeyword_0());
            		
            otherlv_1=(Token)match(input,25,FOLLOW_11); 

            			newLeafNode(otherlv_1, grammarAccess.getHumanActorAccess().getColonColonKeyword_1());
            		
            // InternalUcm4iot.g:3096:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalUcm4iot.g:3097:4: (lv_name_2_0= RULE_ID )
            {
            // InternalUcm4iot.g:3097:4: (lv_name_2_0= RULE_ID )
            // InternalUcm4iot.g:3098:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_2_0, grammarAccess.getHumanActorAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHumanActorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHumanActor"


    // $ANTLR start "entryRuleSoftwareActor"
    // InternalUcm4iot.g:3118:1: entryRuleSoftwareActor returns [EObject current=null] : iv_ruleSoftwareActor= ruleSoftwareActor EOF ;
    public final EObject entryRuleSoftwareActor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSoftwareActor = null;


        try {
            // InternalUcm4iot.g:3118:54: (iv_ruleSoftwareActor= ruleSoftwareActor EOF )
            // InternalUcm4iot.g:3119:2: iv_ruleSoftwareActor= ruleSoftwareActor EOF
            {
             newCompositeNode(grammarAccess.getSoftwareActorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSoftwareActor=ruleSoftwareActor();

            state._fsp--;

             current =iv_ruleSoftwareActor; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSoftwareActor"


    // $ANTLR start "ruleSoftwareActor"
    // InternalUcm4iot.g:3125:1: ruleSoftwareActor returns [EObject current=null] : (otherlv_0= 'SOFTWARE' otherlv_1= '::' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleSoftwareActor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;


        	enterRule();

        try {
            // InternalUcm4iot.g:3131:2: ( (otherlv_0= 'SOFTWARE' otherlv_1= '::' ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalUcm4iot.g:3132:2: (otherlv_0= 'SOFTWARE' otherlv_1= '::' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalUcm4iot.g:3132:2: (otherlv_0= 'SOFTWARE' otherlv_1= '::' ( (lv_name_2_0= RULE_ID ) ) )
            // InternalUcm4iot.g:3133:3: otherlv_0= 'SOFTWARE' otherlv_1= '::' ( (lv_name_2_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,28,FOLLOW_41); 

            			newLeafNode(otherlv_0, grammarAccess.getSoftwareActorAccess().getSOFTWAREKeyword_0());
            		
            otherlv_1=(Token)match(input,25,FOLLOW_11); 

            			newLeafNode(otherlv_1, grammarAccess.getSoftwareActorAccess().getColonColonKeyword_1());
            		
            // InternalUcm4iot.g:3141:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalUcm4iot.g:3142:4: (lv_name_2_0= RULE_ID )
            {
            // InternalUcm4iot.g:3142:4: (lv_name_2_0= RULE_ID )
            // InternalUcm4iot.g:3143:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_2_0, grammarAccess.getSoftwareActorAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSoftwareActorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSoftwareActor"


    // $ANTLR start "entryRuleDeviceActor"
    // InternalUcm4iot.g:3163:1: entryRuleDeviceActor returns [EObject current=null] : iv_ruleDeviceActor= ruleDeviceActor EOF ;
    public final EObject entryRuleDeviceActor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeviceActor = null;


        try {
            // InternalUcm4iot.g:3163:52: (iv_ruleDeviceActor= ruleDeviceActor EOF )
            // InternalUcm4iot.g:3164:2: iv_ruleDeviceActor= ruleDeviceActor EOF
            {
             newCompositeNode(grammarAccess.getDeviceActorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDeviceActor=ruleDeviceActor();

            state._fsp--;

             current =iv_ruleDeviceActor; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDeviceActor"


    // $ANTLR start "ruleDeviceActor"
    // InternalUcm4iot.g:3170:1: ruleDeviceActor returns [EObject current=null] : ( (otherlv_0= 'SENSOR' | otherlv_1= 'ACTUATOR' | otherlv_2= 'TAG' | otherlv_3= 'READER' ) otherlv_4= '::' ( (lv_name_5_0= RULE_ID ) ) ) ;
    public final EObject ruleDeviceActor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_name_5_0=null;


        	enterRule();

        try {
            // InternalUcm4iot.g:3176:2: ( ( (otherlv_0= 'SENSOR' | otherlv_1= 'ACTUATOR' | otherlv_2= 'TAG' | otherlv_3= 'READER' ) otherlv_4= '::' ( (lv_name_5_0= RULE_ID ) ) ) )
            // InternalUcm4iot.g:3177:2: ( (otherlv_0= 'SENSOR' | otherlv_1= 'ACTUATOR' | otherlv_2= 'TAG' | otherlv_3= 'READER' ) otherlv_4= '::' ( (lv_name_5_0= RULE_ID ) ) )
            {
            // InternalUcm4iot.g:3177:2: ( (otherlv_0= 'SENSOR' | otherlv_1= 'ACTUATOR' | otherlv_2= 'TAG' | otherlv_3= 'READER' ) otherlv_4= '::' ( (lv_name_5_0= RULE_ID ) ) )
            // InternalUcm4iot.g:3178:3: (otherlv_0= 'SENSOR' | otherlv_1= 'ACTUATOR' | otherlv_2= 'TAG' | otherlv_3= 'READER' ) otherlv_4= '::' ( (lv_name_5_0= RULE_ID ) )
            {
            // InternalUcm4iot.g:3178:3: (otherlv_0= 'SENSOR' | otherlv_1= 'ACTUATOR' | otherlv_2= 'TAG' | otherlv_3= 'READER' )
            int alt52=4;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt52=1;
                }
                break;
            case 30:
                {
                alt52=2;
                }
                break;
            case 31:
                {
                alt52=3;
                }
                break;
            case 32:
                {
                alt52=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }

            switch (alt52) {
                case 1 :
                    // InternalUcm4iot.g:3179:4: otherlv_0= 'SENSOR'
                    {
                    otherlv_0=(Token)match(input,29,FOLLOW_41); 

                    				newLeafNode(otherlv_0, grammarAccess.getDeviceActorAccess().getSENSORKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:3184:4: otherlv_1= 'ACTUATOR'
                    {
                    otherlv_1=(Token)match(input,30,FOLLOW_41); 

                    				newLeafNode(otherlv_1, grammarAccess.getDeviceActorAccess().getACTUATORKeyword_0_1());
                    			

                    }
                    break;
                case 3 :
                    // InternalUcm4iot.g:3189:4: otherlv_2= 'TAG'
                    {
                    otherlv_2=(Token)match(input,31,FOLLOW_41); 

                    				newLeafNode(otherlv_2, grammarAccess.getDeviceActorAccess().getTAGKeyword_0_2());
                    			

                    }
                    break;
                case 4 :
                    // InternalUcm4iot.g:3194:4: otherlv_3= 'READER'
                    {
                    otherlv_3=(Token)match(input,32,FOLLOW_41); 

                    				newLeafNode(otherlv_3, grammarAccess.getDeviceActorAccess().getREADERKeyword_0_3());
                    			

                    }
                    break;

            }

            otherlv_4=(Token)match(input,25,FOLLOW_11); 

            			newLeafNode(otherlv_4, grammarAccess.getDeviceActorAccess().getColonColonKeyword_1());
            		
            // InternalUcm4iot.g:3203:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalUcm4iot.g:3204:4: (lv_name_5_0= RULE_ID )
            {
            // InternalUcm4iot.g:3204:4: (lv_name_5_0= RULE_ID )
            // InternalUcm4iot.g:3205:5: lv_name_5_0= RULE_ID
            {
            lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_5_0, grammarAccess.getDeviceActorAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDeviceActorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_5_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDeviceActor"


    // $ANTLR start "entryRulePhysicalEntityActor"
    // InternalUcm4iot.g:3225:1: entryRulePhysicalEntityActor returns [EObject current=null] : iv_rulePhysicalEntityActor= rulePhysicalEntityActor EOF ;
    public final EObject entryRulePhysicalEntityActor() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePhysicalEntityActor = null;


        try {
            // InternalUcm4iot.g:3225:60: (iv_rulePhysicalEntityActor= rulePhysicalEntityActor EOF )
            // InternalUcm4iot.g:3226:2: iv_rulePhysicalEntityActor= rulePhysicalEntityActor EOF
            {
             newCompositeNode(grammarAccess.getPhysicalEntityActorRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePhysicalEntityActor=rulePhysicalEntityActor();

            state._fsp--;

             current =iv_rulePhysicalEntityActor; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePhysicalEntityActor"


    // $ANTLR start "rulePhysicalEntityActor"
    // InternalUcm4iot.g:3232:1: rulePhysicalEntityActor returns [EObject current=null] : (otherlv_0= 'PHYSICAL_ENTITY' otherlv_1= '::' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject rulePhysicalEntityActor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;


        	enterRule();

        try {
            // InternalUcm4iot.g:3238:2: ( (otherlv_0= 'PHYSICAL_ENTITY' otherlv_1= '::' ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalUcm4iot.g:3239:2: (otherlv_0= 'PHYSICAL_ENTITY' otherlv_1= '::' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalUcm4iot.g:3239:2: (otherlv_0= 'PHYSICAL_ENTITY' otherlv_1= '::' ( (lv_name_2_0= RULE_ID ) ) )
            // InternalUcm4iot.g:3240:3: otherlv_0= 'PHYSICAL_ENTITY' otherlv_1= '::' ( (lv_name_2_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,33,FOLLOW_41); 

            			newLeafNode(otherlv_0, grammarAccess.getPhysicalEntityActorAccess().getPHYSICAL_ENTITYKeyword_0());
            		
            otherlv_1=(Token)match(input,25,FOLLOW_11); 

            			newLeafNode(otherlv_1, grammarAccess.getPhysicalEntityActorAccess().getColonColonKeyword_1());
            		
            // InternalUcm4iot.g:3248:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalUcm4iot.g:3249:4: (lv_name_2_0= RULE_ID )
            {
            // InternalUcm4iot.g:3249:4: (lv_name_2_0= RULE_ID )
            // InternalUcm4iot.g:3250:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_2_0, grammarAccess.getPhysicalEntityActorAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPhysicalEntityActorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePhysicalEntityActor"


    // $ANTLR start "entryRuleKeywordStandardMode"
    // InternalUcm4iot.g:3270:1: entryRuleKeywordStandardMode returns [String current=null] : iv_ruleKeywordStandardMode= ruleKeywordStandardMode EOF ;
    public final String entryRuleKeywordStandardMode() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKeywordStandardMode = null;


        try {
            // InternalUcm4iot.g:3270:59: (iv_ruleKeywordStandardMode= ruleKeywordStandardMode EOF )
            // InternalUcm4iot.g:3271:2: iv_ruleKeywordStandardMode= ruleKeywordStandardMode EOF
            {
             newCompositeNode(grammarAccess.getKeywordStandardModeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleKeywordStandardMode=ruleKeywordStandardMode();

            state._fsp--;

             current =iv_ruleKeywordStandardMode.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKeywordStandardMode"


    // $ANTLR start "ruleKeywordStandardMode"
    // InternalUcm4iot.g:3277:1: ruleKeywordStandardMode returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= 'Standard' | kw= 'standard' ) (kw= 'Mode' | kw= 'mode' ) ) ;
    public final AntlrDatatypeRuleToken ruleKeywordStandardMode() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalUcm4iot.g:3283:2: ( ( (kw= 'Standard' | kw= 'standard' ) (kw= 'Mode' | kw= 'mode' ) ) )
            // InternalUcm4iot.g:3284:2: ( (kw= 'Standard' | kw= 'standard' ) (kw= 'Mode' | kw= 'mode' ) )
            {
            // InternalUcm4iot.g:3284:2: ( (kw= 'Standard' | kw= 'standard' ) (kw= 'Mode' | kw= 'mode' ) )
            // InternalUcm4iot.g:3285:3: (kw= 'Standard' | kw= 'standard' ) (kw= 'Mode' | kw= 'mode' )
            {
            // InternalUcm4iot.g:3285:3: (kw= 'Standard' | kw= 'standard' )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==34) ) {
                alt53=1;
            }
            else if ( (LA53_0==35) ) {
                alt53=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }
            switch (alt53) {
                case 1 :
                    // InternalUcm4iot.g:3286:4: kw= 'Standard'
                    {
                    kw=(Token)match(input,34,FOLLOW_48); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordStandardModeAccess().getStandardKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:3292:4: kw= 'standard'
                    {
                    kw=(Token)match(input,35,FOLLOW_48); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordStandardModeAccess().getStandardKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalUcm4iot.g:3298:3: (kw= 'Mode' | kw= 'mode' )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==36) ) {
                alt54=1;
            }
            else if ( (LA54_0==37) ) {
                alt54=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }
            switch (alt54) {
                case 1 :
                    // InternalUcm4iot.g:3299:4: kw= 'Mode'
                    {
                    kw=(Token)match(input,36,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordStandardModeAccess().getModeKeyword_1_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:3305:4: kw= 'mode'
                    {
                    kw=(Token)match(input,37,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordStandardModeAccess().getModeKeyword_1_1());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKeywordStandardMode"


    // $ANTLR start "entryRuleKeywordExceptionalUseCase"
    // InternalUcm4iot.g:3315:1: entryRuleKeywordExceptionalUseCase returns [String current=null] : iv_ruleKeywordExceptionalUseCase= ruleKeywordExceptionalUseCase EOF ;
    public final String entryRuleKeywordExceptionalUseCase() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKeywordExceptionalUseCase = null;


        try {
            // InternalUcm4iot.g:3315:65: (iv_ruleKeywordExceptionalUseCase= ruleKeywordExceptionalUseCase EOF )
            // InternalUcm4iot.g:3316:2: iv_ruleKeywordExceptionalUseCase= ruleKeywordExceptionalUseCase EOF
            {
             newCompositeNode(grammarAccess.getKeywordExceptionalUseCaseRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleKeywordExceptionalUseCase=ruleKeywordExceptionalUseCase();

            state._fsp--;

             current =iv_ruleKeywordExceptionalUseCase.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKeywordExceptionalUseCase"


    // $ANTLR start "ruleKeywordExceptionalUseCase"
    // InternalUcm4iot.g:3322:1: ruleKeywordExceptionalUseCase returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= 'Use' | kw= 'use' ) (kw= 'Case' | kw= 'case' ) ) ;
    public final AntlrDatatypeRuleToken ruleKeywordExceptionalUseCase() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalUcm4iot.g:3328:2: ( ( (kw= 'Use' | kw= 'use' ) (kw= 'Case' | kw= 'case' ) ) )
            // InternalUcm4iot.g:3329:2: ( (kw= 'Use' | kw= 'use' ) (kw= 'Case' | kw= 'case' ) )
            {
            // InternalUcm4iot.g:3329:2: ( (kw= 'Use' | kw= 'use' ) (kw= 'Case' | kw= 'case' ) )
            // InternalUcm4iot.g:3330:3: (kw= 'Use' | kw= 'use' ) (kw= 'Case' | kw= 'case' )
            {
            // InternalUcm4iot.g:3330:3: (kw= 'Use' | kw= 'use' )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==38) ) {
                alt55=1;
            }
            else if ( (LA55_0==39) ) {
                alt55=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }
            switch (alt55) {
                case 1 :
                    // InternalUcm4iot.g:3331:4: kw= 'Use'
                    {
                    kw=(Token)match(input,38,FOLLOW_49); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordExceptionalUseCaseAccess().getUseKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:3337:4: kw= 'use'
                    {
                    kw=(Token)match(input,39,FOLLOW_49); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordExceptionalUseCaseAccess().getUseKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalUcm4iot.g:3343:3: (kw= 'Case' | kw= 'case' )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==40) ) {
                alt56=1;
            }
            else if ( (LA56_0==41) ) {
                alt56=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }
            switch (alt56) {
                case 1 :
                    // InternalUcm4iot.g:3344:4: kw= 'Case'
                    {
                    kw=(Token)match(input,40,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordExceptionalUseCaseAccess().getCaseKeyword_1_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:3350:4: kw= 'case'
                    {
                    kw=(Token)match(input,41,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordExceptionalUseCaseAccess().getCaseKeyword_1_1());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKeywordExceptionalUseCase"


    // $ANTLR start "entryRuleKeywordHandlerUseCase"
    // InternalUcm4iot.g:3360:1: entryRuleKeywordHandlerUseCase returns [String current=null] : iv_ruleKeywordHandlerUseCase= ruleKeywordHandlerUseCase EOF ;
    public final String entryRuleKeywordHandlerUseCase() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKeywordHandlerUseCase = null;


        try {
            // InternalUcm4iot.g:3360:61: (iv_ruleKeywordHandlerUseCase= ruleKeywordHandlerUseCase EOF )
            // InternalUcm4iot.g:3361:2: iv_ruleKeywordHandlerUseCase= ruleKeywordHandlerUseCase EOF
            {
             newCompositeNode(grammarAccess.getKeywordHandlerUseCaseRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleKeywordHandlerUseCase=ruleKeywordHandlerUseCase();

            state._fsp--;

             current =iv_ruleKeywordHandlerUseCase.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKeywordHandlerUseCase"


    // $ANTLR start "ruleKeywordHandlerUseCase"
    // InternalUcm4iot.g:3367:1: ruleKeywordHandlerUseCase returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= 'Handler' | kw= 'handler' ) (kw= 'Use' | kw= 'use' ) (kw= 'Case' | kw= 'case' ) ) ;
    public final AntlrDatatypeRuleToken ruleKeywordHandlerUseCase() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalUcm4iot.g:3373:2: ( ( (kw= 'Handler' | kw= 'handler' ) (kw= 'Use' | kw= 'use' ) (kw= 'Case' | kw= 'case' ) ) )
            // InternalUcm4iot.g:3374:2: ( (kw= 'Handler' | kw= 'handler' ) (kw= 'Use' | kw= 'use' ) (kw= 'Case' | kw= 'case' ) )
            {
            // InternalUcm4iot.g:3374:2: ( (kw= 'Handler' | kw= 'handler' ) (kw= 'Use' | kw= 'use' ) (kw= 'Case' | kw= 'case' ) )
            // InternalUcm4iot.g:3375:3: (kw= 'Handler' | kw= 'handler' ) (kw= 'Use' | kw= 'use' ) (kw= 'Case' | kw= 'case' )
            {
            // InternalUcm4iot.g:3375:3: (kw= 'Handler' | kw= 'handler' )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==42) ) {
                alt57=1;
            }
            else if ( (LA57_0==43) ) {
                alt57=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }
            switch (alt57) {
                case 1 :
                    // InternalUcm4iot.g:3376:4: kw= 'Handler'
                    {
                    kw=(Token)match(input,42,FOLLOW_50); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordHandlerUseCaseAccess().getHandlerKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:3382:4: kw= 'handler'
                    {
                    kw=(Token)match(input,43,FOLLOW_50); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordHandlerUseCaseAccess().getHandlerKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalUcm4iot.g:3388:3: (kw= 'Use' | kw= 'use' )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==38) ) {
                alt58=1;
            }
            else if ( (LA58_0==39) ) {
                alt58=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }
            switch (alt58) {
                case 1 :
                    // InternalUcm4iot.g:3389:4: kw= 'Use'
                    {
                    kw=(Token)match(input,38,FOLLOW_49); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordHandlerUseCaseAccess().getUseKeyword_1_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:3395:4: kw= 'use'
                    {
                    kw=(Token)match(input,39,FOLLOW_49); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordHandlerUseCaseAccess().getUseKeyword_1_1());
                    			

                    }
                    break;

            }

            // InternalUcm4iot.g:3401:3: (kw= 'Case' | kw= 'case' )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==40) ) {
                alt59=1;
            }
            else if ( (LA59_0==41) ) {
                alt59=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // InternalUcm4iot.g:3402:4: kw= 'Case'
                    {
                    kw=(Token)match(input,40,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordHandlerUseCaseAccess().getCaseKeyword_2_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:3408:4: kw= 'case'
                    {
                    kw=(Token)match(input,41,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordHandlerUseCaseAccess().getCaseKeyword_2_1());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKeywordHandlerUseCase"


    // $ANTLR start "entryRuleKeywordScope"
    // InternalUcm4iot.g:3418:1: entryRuleKeywordScope returns [String current=null] : iv_ruleKeywordScope= ruleKeywordScope EOF ;
    public final String entryRuleKeywordScope() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKeywordScope = null;


        try {
            // InternalUcm4iot.g:3418:52: (iv_ruleKeywordScope= ruleKeywordScope EOF )
            // InternalUcm4iot.g:3419:2: iv_ruleKeywordScope= ruleKeywordScope EOF
            {
             newCompositeNode(grammarAccess.getKeywordScopeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleKeywordScope=ruleKeywordScope();

            state._fsp--;

             current =iv_ruleKeywordScope.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKeywordScope"


    // $ANTLR start "ruleKeywordScope"
    // InternalUcm4iot.g:3425:1: ruleKeywordScope returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Scope' | kw= 'scope' ) ;
    public final AntlrDatatypeRuleToken ruleKeywordScope() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalUcm4iot.g:3431:2: ( (kw= 'Scope' | kw= 'scope' ) )
            // InternalUcm4iot.g:3432:2: (kw= 'Scope' | kw= 'scope' )
            {
            // InternalUcm4iot.g:3432:2: (kw= 'Scope' | kw= 'scope' )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==44) ) {
                alt60=1;
            }
            else if ( (LA60_0==45) ) {
                alt60=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }
            switch (alt60) {
                case 1 :
                    // InternalUcm4iot.g:3433:3: kw= 'Scope'
                    {
                    kw=(Token)match(input,44,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordScopeAccess().getScopeKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:3439:3: kw= 'scope'
                    {
                    kw=(Token)match(input,45,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordScopeAccess().getScopeKeyword_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKeywordScope"


    // $ANTLR start "entryRuleKeywordIntention"
    // InternalUcm4iot.g:3448:1: entryRuleKeywordIntention returns [String current=null] : iv_ruleKeywordIntention= ruleKeywordIntention EOF ;
    public final String entryRuleKeywordIntention() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKeywordIntention = null;


        try {
            // InternalUcm4iot.g:3448:56: (iv_ruleKeywordIntention= ruleKeywordIntention EOF )
            // InternalUcm4iot.g:3449:2: iv_ruleKeywordIntention= ruleKeywordIntention EOF
            {
             newCompositeNode(grammarAccess.getKeywordIntentionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleKeywordIntention=ruleKeywordIntention();

            state._fsp--;

             current =iv_ruleKeywordIntention.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKeywordIntention"


    // $ANTLR start "ruleKeywordIntention"
    // InternalUcm4iot.g:3455:1: ruleKeywordIntention returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Intention' | kw= 'intention' ) ;
    public final AntlrDatatypeRuleToken ruleKeywordIntention() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalUcm4iot.g:3461:2: ( (kw= 'Intention' | kw= 'intention' ) )
            // InternalUcm4iot.g:3462:2: (kw= 'Intention' | kw= 'intention' )
            {
            // InternalUcm4iot.g:3462:2: (kw= 'Intention' | kw= 'intention' )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==46) ) {
                alt61=1;
            }
            else if ( (LA61_0==47) ) {
                alt61=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }
            switch (alt61) {
                case 1 :
                    // InternalUcm4iot.g:3463:3: kw= 'Intention'
                    {
                    kw=(Token)match(input,46,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordIntentionAccess().getIntentionKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:3469:3: kw= 'intention'
                    {
                    kw=(Token)match(input,47,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordIntentionAccess().getIntentionKeyword_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKeywordIntention"


    // $ANTLR start "entryRuleKeywordLevel"
    // InternalUcm4iot.g:3478:1: entryRuleKeywordLevel returns [String current=null] : iv_ruleKeywordLevel= ruleKeywordLevel EOF ;
    public final String entryRuleKeywordLevel() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKeywordLevel = null;


        try {
            // InternalUcm4iot.g:3478:52: (iv_ruleKeywordLevel= ruleKeywordLevel EOF )
            // InternalUcm4iot.g:3479:2: iv_ruleKeywordLevel= ruleKeywordLevel EOF
            {
             newCompositeNode(grammarAccess.getKeywordLevelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleKeywordLevel=ruleKeywordLevel();

            state._fsp--;

             current =iv_ruleKeywordLevel.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKeywordLevel"


    // $ANTLR start "ruleKeywordLevel"
    // InternalUcm4iot.g:3485:1: ruleKeywordLevel returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Level' | kw= 'level' ) ;
    public final AntlrDatatypeRuleToken ruleKeywordLevel() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalUcm4iot.g:3491:2: ( (kw= 'Level' | kw= 'level' ) )
            // InternalUcm4iot.g:3492:2: (kw= 'Level' | kw= 'level' )
            {
            // InternalUcm4iot.g:3492:2: (kw= 'Level' | kw= 'level' )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==48) ) {
                alt62=1;
            }
            else if ( (LA62_0==49) ) {
                alt62=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }
            switch (alt62) {
                case 1 :
                    // InternalUcm4iot.g:3493:3: kw= 'Level'
                    {
                    kw=(Token)match(input,48,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordLevelAccess().getLevelKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:3499:3: kw= 'level'
                    {
                    kw=(Token)match(input,49,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordLevelAccess().getLevelKeyword_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKeywordLevel"


    // $ANTLR start "entryRuleKeywordMultiplicity"
    // InternalUcm4iot.g:3508:1: entryRuleKeywordMultiplicity returns [String current=null] : iv_ruleKeywordMultiplicity= ruleKeywordMultiplicity EOF ;
    public final String entryRuleKeywordMultiplicity() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKeywordMultiplicity = null;


        try {
            // InternalUcm4iot.g:3508:59: (iv_ruleKeywordMultiplicity= ruleKeywordMultiplicity EOF )
            // InternalUcm4iot.g:3509:2: iv_ruleKeywordMultiplicity= ruleKeywordMultiplicity EOF
            {
             newCompositeNode(grammarAccess.getKeywordMultiplicityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleKeywordMultiplicity=ruleKeywordMultiplicity();

            state._fsp--;

             current =iv_ruleKeywordMultiplicity.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKeywordMultiplicity"


    // $ANTLR start "ruleKeywordMultiplicity"
    // InternalUcm4iot.g:3515:1: ruleKeywordMultiplicity returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Multiplicity' | kw= 'multiplicity' ) ;
    public final AntlrDatatypeRuleToken ruleKeywordMultiplicity() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalUcm4iot.g:3521:2: ( (kw= 'Multiplicity' | kw= 'multiplicity' ) )
            // InternalUcm4iot.g:3522:2: (kw= 'Multiplicity' | kw= 'multiplicity' )
            {
            // InternalUcm4iot.g:3522:2: (kw= 'Multiplicity' | kw= 'multiplicity' )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==50) ) {
                alt63=1;
            }
            else if ( (LA63_0==51) ) {
                alt63=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }
            switch (alt63) {
                case 1 :
                    // InternalUcm4iot.g:3523:3: kw= 'Multiplicity'
                    {
                    kw=(Token)match(input,50,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordMultiplicityAccess().getMultiplicityKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:3529:3: kw= 'multiplicity'
                    {
                    kw=(Token)match(input,51,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordMultiplicityAccess().getMultiplicityKeyword_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKeywordMultiplicity"


    // $ANTLR start "entryRuleKeywordPrecondition"
    // InternalUcm4iot.g:3538:1: entryRuleKeywordPrecondition returns [String current=null] : iv_ruleKeywordPrecondition= ruleKeywordPrecondition EOF ;
    public final String entryRuleKeywordPrecondition() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKeywordPrecondition = null;


        try {
            // InternalUcm4iot.g:3538:59: (iv_ruleKeywordPrecondition= ruleKeywordPrecondition EOF )
            // InternalUcm4iot.g:3539:2: iv_ruleKeywordPrecondition= ruleKeywordPrecondition EOF
            {
             newCompositeNode(grammarAccess.getKeywordPreconditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleKeywordPrecondition=ruleKeywordPrecondition();

            state._fsp--;

             current =iv_ruleKeywordPrecondition.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKeywordPrecondition"


    // $ANTLR start "ruleKeywordPrecondition"
    // InternalUcm4iot.g:3545:1: ruleKeywordPrecondition returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Precondition' | kw= 'precondition' ) ;
    public final AntlrDatatypeRuleToken ruleKeywordPrecondition() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalUcm4iot.g:3551:2: ( (kw= 'Precondition' | kw= 'precondition' ) )
            // InternalUcm4iot.g:3552:2: (kw= 'Precondition' | kw= 'precondition' )
            {
            // InternalUcm4iot.g:3552:2: (kw= 'Precondition' | kw= 'precondition' )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==52) ) {
                alt64=1;
            }
            else if ( (LA64_0==53) ) {
                alt64=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }
            switch (alt64) {
                case 1 :
                    // InternalUcm4iot.g:3553:3: kw= 'Precondition'
                    {
                    kw=(Token)match(input,52,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordPreconditionAccess().getPreconditionKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:3559:3: kw= 'precondition'
                    {
                    kw=(Token)match(input,53,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordPreconditionAccess().getPreconditionKeyword_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKeywordPrecondition"


    // $ANTLR start "entryRuleKeywordPostcondition"
    // InternalUcm4iot.g:3568:1: entryRuleKeywordPostcondition returns [String current=null] : iv_ruleKeywordPostcondition= ruleKeywordPostcondition EOF ;
    public final String entryRuleKeywordPostcondition() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKeywordPostcondition = null;


        try {
            // InternalUcm4iot.g:3568:60: (iv_ruleKeywordPostcondition= ruleKeywordPostcondition EOF )
            // InternalUcm4iot.g:3569:2: iv_ruleKeywordPostcondition= ruleKeywordPostcondition EOF
            {
             newCompositeNode(grammarAccess.getKeywordPostconditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleKeywordPostcondition=ruleKeywordPostcondition();

            state._fsp--;

             current =iv_ruleKeywordPostcondition.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKeywordPostcondition"


    // $ANTLR start "ruleKeywordPostcondition"
    // InternalUcm4iot.g:3575:1: ruleKeywordPostcondition returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Postcondition' | kw= 'postcondition' ) ;
    public final AntlrDatatypeRuleToken ruleKeywordPostcondition() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalUcm4iot.g:3581:2: ( (kw= 'Postcondition' | kw= 'postcondition' ) )
            // InternalUcm4iot.g:3582:2: (kw= 'Postcondition' | kw= 'postcondition' )
            {
            // InternalUcm4iot.g:3582:2: (kw= 'Postcondition' | kw= 'postcondition' )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==54) ) {
                alt65=1;
            }
            else if ( (LA65_0==55) ) {
                alt65=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // InternalUcm4iot.g:3583:3: kw= 'Postcondition'
                    {
                    kw=(Token)match(input,54,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordPostconditionAccess().getPostconditionKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:3589:3: kw= 'postcondition'
                    {
                    kw=(Token)match(input,55,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordPostconditionAccess().getPostconditionKeyword_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKeywordPostcondition"


    // $ANTLR start "entryRuleKeywordHandlerClass"
    // InternalUcm4iot.g:3598:1: entryRuleKeywordHandlerClass returns [String current=null] : iv_ruleKeywordHandlerClass= ruleKeywordHandlerClass EOF ;
    public final String entryRuleKeywordHandlerClass() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKeywordHandlerClass = null;


        try {
            // InternalUcm4iot.g:3598:59: (iv_ruleKeywordHandlerClass= ruleKeywordHandlerClass EOF )
            // InternalUcm4iot.g:3599:2: iv_ruleKeywordHandlerClass= ruleKeywordHandlerClass EOF
            {
             newCompositeNode(grammarAccess.getKeywordHandlerClassRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleKeywordHandlerClass=ruleKeywordHandlerClass();

            state._fsp--;

             current =iv_ruleKeywordHandlerClass.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKeywordHandlerClass"


    // $ANTLR start "ruleKeywordHandlerClass"
    // InternalUcm4iot.g:3605:1: ruleKeywordHandlerClass returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= 'Handler' | kw= 'handler' ) (kw= 'Class' | kw= 'class' ) ) ;
    public final AntlrDatatypeRuleToken ruleKeywordHandlerClass() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalUcm4iot.g:3611:2: ( ( (kw= 'Handler' | kw= 'handler' ) (kw= 'Class' | kw= 'class' ) ) )
            // InternalUcm4iot.g:3612:2: ( (kw= 'Handler' | kw= 'handler' ) (kw= 'Class' | kw= 'class' ) )
            {
            // InternalUcm4iot.g:3612:2: ( (kw= 'Handler' | kw= 'handler' ) (kw= 'Class' | kw= 'class' ) )
            // InternalUcm4iot.g:3613:3: (kw= 'Handler' | kw= 'handler' ) (kw= 'Class' | kw= 'class' )
            {
            // InternalUcm4iot.g:3613:3: (kw= 'Handler' | kw= 'handler' )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==42) ) {
                alt66=1;
            }
            else if ( (LA66_0==43) ) {
                alt66=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }
            switch (alt66) {
                case 1 :
                    // InternalUcm4iot.g:3614:4: kw= 'Handler'
                    {
                    kw=(Token)match(input,42,FOLLOW_51); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordHandlerClassAccess().getHandlerKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:3620:4: kw= 'handler'
                    {
                    kw=(Token)match(input,43,FOLLOW_51); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordHandlerClassAccess().getHandlerKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalUcm4iot.g:3626:3: (kw= 'Class' | kw= 'class' )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==56) ) {
                alt67=1;
            }
            else if ( (LA67_0==57) ) {
                alt67=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }
            switch (alt67) {
                case 1 :
                    // InternalUcm4iot.g:3627:4: kw= 'Class'
                    {
                    kw=(Token)match(input,56,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordHandlerClassAccess().getClassKeyword_1_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:3633:4: kw= 'class'
                    {
                    kw=(Token)match(input,57,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordHandlerClassAccess().getClassKeyword_1_1());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKeywordHandlerClass"


    // $ANTLR start "entryRuleKeywordContextException"
    // InternalUcm4iot.g:3643:1: entryRuleKeywordContextException returns [String current=null] : iv_ruleKeywordContextException= ruleKeywordContextException EOF ;
    public final String entryRuleKeywordContextException() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKeywordContextException = null;


        try {
            // InternalUcm4iot.g:3643:63: (iv_ruleKeywordContextException= ruleKeywordContextException EOF )
            // InternalUcm4iot.g:3644:2: iv_ruleKeywordContextException= ruleKeywordContextException EOF
            {
             newCompositeNode(grammarAccess.getKeywordContextExceptionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleKeywordContextException=ruleKeywordContextException();

            state._fsp--;

             current =iv_ruleKeywordContextException.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKeywordContextException"


    // $ANTLR start "ruleKeywordContextException"
    // InternalUcm4iot.g:3650:1: ruleKeywordContextException returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= 'Contexts' | kw= 'contexts' ) (kw= 'And' | kw= 'and' ) (kw= 'Exceptions' | kw= 'exceptions' ) ) ;
    public final AntlrDatatypeRuleToken ruleKeywordContextException() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalUcm4iot.g:3656:2: ( ( (kw= 'Contexts' | kw= 'contexts' ) (kw= 'And' | kw= 'and' ) (kw= 'Exceptions' | kw= 'exceptions' ) ) )
            // InternalUcm4iot.g:3657:2: ( (kw= 'Contexts' | kw= 'contexts' ) (kw= 'And' | kw= 'and' ) (kw= 'Exceptions' | kw= 'exceptions' ) )
            {
            // InternalUcm4iot.g:3657:2: ( (kw= 'Contexts' | kw= 'contexts' ) (kw= 'And' | kw= 'and' ) (kw= 'Exceptions' | kw= 'exceptions' ) )
            // InternalUcm4iot.g:3658:3: (kw= 'Contexts' | kw= 'contexts' ) (kw= 'And' | kw= 'and' ) (kw= 'Exceptions' | kw= 'exceptions' )
            {
            // InternalUcm4iot.g:3658:3: (kw= 'Contexts' | kw= 'contexts' )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==58) ) {
                alt68=1;
            }
            else if ( (LA68_0==59) ) {
                alt68=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }
            switch (alt68) {
                case 1 :
                    // InternalUcm4iot.g:3659:4: kw= 'Contexts'
                    {
                    kw=(Token)match(input,58,FOLLOW_52); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordContextExceptionAccess().getContextsKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:3665:4: kw= 'contexts'
                    {
                    kw=(Token)match(input,59,FOLLOW_52); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordContextExceptionAccess().getContextsKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalUcm4iot.g:3671:3: (kw= 'And' | kw= 'and' )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==60) ) {
                alt69=1;
            }
            else if ( (LA69_0==61) ) {
                alt69=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }
            switch (alt69) {
                case 1 :
                    // InternalUcm4iot.g:3672:4: kw= 'And'
                    {
                    kw=(Token)match(input,60,FOLLOW_53); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordContextExceptionAccess().getAndKeyword_1_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:3678:4: kw= 'and'
                    {
                    kw=(Token)match(input,61,FOLLOW_53); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordContextExceptionAccess().getAndKeyword_1_1());
                    			

                    }
                    break;

            }

            // InternalUcm4iot.g:3684:3: (kw= 'Exceptions' | kw= 'exceptions' )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==62) ) {
                alt70=1;
            }
            else if ( (LA70_0==63) ) {
                alt70=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }
            switch (alt70) {
                case 1 :
                    // InternalUcm4iot.g:3685:4: kw= 'Exceptions'
                    {
                    kw=(Token)match(input,62,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordContextExceptionAccess().getExceptionsKeyword_2_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:3691:4: kw= 'exceptions'
                    {
                    kw=(Token)match(input,63,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordContextExceptionAccess().getExceptionsKeyword_2_1());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKeywordContextException"


    // $ANTLR start "entryRuleKeywordMainSuccessScenario"
    // InternalUcm4iot.g:3701:1: entryRuleKeywordMainSuccessScenario returns [String current=null] : iv_ruleKeywordMainSuccessScenario= ruleKeywordMainSuccessScenario EOF ;
    public final String entryRuleKeywordMainSuccessScenario() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKeywordMainSuccessScenario = null;


        try {
            // InternalUcm4iot.g:3701:66: (iv_ruleKeywordMainSuccessScenario= ruleKeywordMainSuccessScenario EOF )
            // InternalUcm4iot.g:3702:2: iv_ruleKeywordMainSuccessScenario= ruleKeywordMainSuccessScenario EOF
            {
             newCompositeNode(grammarAccess.getKeywordMainSuccessScenarioRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleKeywordMainSuccessScenario=ruleKeywordMainSuccessScenario();

            state._fsp--;

             current =iv_ruleKeywordMainSuccessScenario.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKeywordMainSuccessScenario"


    // $ANTLR start "ruleKeywordMainSuccessScenario"
    // InternalUcm4iot.g:3708:1: ruleKeywordMainSuccessScenario returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= 'Main' | kw= 'main' ) (kw= 'Success' | kw= 'success' )? (kw= 'Scenario' | kw= 'scenario' )? ) ;
    public final AntlrDatatypeRuleToken ruleKeywordMainSuccessScenario() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalUcm4iot.g:3714:2: ( ( (kw= 'Main' | kw= 'main' ) (kw= 'Success' | kw= 'success' )? (kw= 'Scenario' | kw= 'scenario' )? ) )
            // InternalUcm4iot.g:3715:2: ( (kw= 'Main' | kw= 'main' ) (kw= 'Success' | kw= 'success' )? (kw= 'Scenario' | kw= 'scenario' )? )
            {
            // InternalUcm4iot.g:3715:2: ( (kw= 'Main' | kw= 'main' ) (kw= 'Success' | kw= 'success' )? (kw= 'Scenario' | kw= 'scenario' )? )
            // InternalUcm4iot.g:3716:3: (kw= 'Main' | kw= 'main' ) (kw= 'Success' | kw= 'success' )? (kw= 'Scenario' | kw= 'scenario' )?
            {
            // InternalUcm4iot.g:3716:3: (kw= 'Main' | kw= 'main' )
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==64) ) {
                alt71=1;
            }
            else if ( (LA71_0==65) ) {
                alt71=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;
            }
            switch (alt71) {
                case 1 :
                    // InternalUcm4iot.g:3717:4: kw= 'Main'
                    {
                    kw=(Token)match(input,64,FOLLOW_54); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordMainSuccessScenarioAccess().getMainKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:3723:4: kw= 'main'
                    {
                    kw=(Token)match(input,65,FOLLOW_54); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordMainSuccessScenarioAccess().getMainKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalUcm4iot.g:3729:3: (kw= 'Success' | kw= 'success' )?
            int alt72=3;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==66) ) {
                alt72=1;
            }
            else if ( (LA72_0==67) ) {
                alt72=2;
            }
            switch (alt72) {
                case 1 :
                    // InternalUcm4iot.g:3730:4: kw= 'Success'
                    {
                    kw=(Token)match(input,66,FOLLOW_55); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordMainSuccessScenarioAccess().getSuccessKeyword_1_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:3736:4: kw= 'success'
                    {
                    kw=(Token)match(input,67,FOLLOW_55); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordMainSuccessScenarioAccess().getSuccessKeyword_1_1());
                    			

                    }
                    break;

            }

            // InternalUcm4iot.g:3742:3: (kw= 'Scenario' | kw= 'scenario' )?
            int alt73=3;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==68) ) {
                alt73=1;
            }
            else if ( (LA73_0==69) ) {
                alt73=2;
            }
            switch (alt73) {
                case 1 :
                    // InternalUcm4iot.g:3743:4: kw= 'Scenario'
                    {
                    kw=(Token)match(input,68,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordMainSuccessScenarioAccess().getScenarioKeyword_2_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:3749:4: kw= 'scenario'
                    {
                    kw=(Token)match(input,69,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordMainSuccessScenarioAccess().getScenarioKeyword_2_1());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKeywordMainSuccessScenario"


    // $ANTLR start "entryRuleKeywordExtensions"
    // InternalUcm4iot.g:3759:1: entryRuleKeywordExtensions returns [String current=null] : iv_ruleKeywordExtensions= ruleKeywordExtensions EOF ;
    public final String entryRuleKeywordExtensions() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKeywordExtensions = null;


        try {
            // InternalUcm4iot.g:3759:57: (iv_ruleKeywordExtensions= ruleKeywordExtensions EOF )
            // InternalUcm4iot.g:3760:2: iv_ruleKeywordExtensions= ruleKeywordExtensions EOF
            {
             newCompositeNode(grammarAccess.getKeywordExtensionsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleKeywordExtensions=ruleKeywordExtensions();

            state._fsp--;

             current =iv_ruleKeywordExtensions.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKeywordExtensions"


    // $ANTLR start "ruleKeywordExtensions"
    // InternalUcm4iot.g:3766:1: ruleKeywordExtensions returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Extensions' | kw= 'extensions' ) ;
    public final AntlrDatatypeRuleToken ruleKeywordExtensions() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalUcm4iot.g:3772:2: ( (kw= 'Extensions' | kw= 'extensions' ) )
            // InternalUcm4iot.g:3773:2: (kw= 'Extensions' | kw= 'extensions' )
            {
            // InternalUcm4iot.g:3773:2: (kw= 'Extensions' | kw= 'extensions' )
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==70) ) {
                alt74=1;
            }
            else if ( (LA74_0==71) ) {
                alt74=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;
            }
            switch (alt74) {
                case 1 :
                    // InternalUcm4iot.g:3774:3: kw= 'Extensions'
                    {
                    kw=(Token)match(input,70,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordExtensionsAccess().getExtensionsKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:3780:3: kw= 'extensions'
                    {
                    kw=(Token)match(input,71,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordExtensionsAccess().getExtensionsKeyword_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKeywordExtensions"


    // $ANTLR start "entryRuleKeywordAlternateBlock"
    // InternalUcm4iot.g:3789:1: entryRuleKeywordAlternateBlock returns [String current=null] : iv_ruleKeywordAlternateBlock= ruleKeywordAlternateBlock EOF ;
    public final String entryRuleKeywordAlternateBlock() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKeywordAlternateBlock = null;


        try {
            // InternalUcm4iot.g:3789:61: (iv_ruleKeywordAlternateBlock= ruleKeywordAlternateBlock EOF )
            // InternalUcm4iot.g:3790:2: iv_ruleKeywordAlternateBlock= ruleKeywordAlternateBlock EOF
            {
             newCompositeNode(grammarAccess.getKeywordAlternateBlockRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleKeywordAlternateBlock=ruleKeywordAlternateBlock();

            state._fsp--;

             current =iv_ruleKeywordAlternateBlock.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKeywordAlternateBlock"


    // $ANTLR start "ruleKeywordAlternateBlock"
    // InternalUcm4iot.g:3796:1: ruleKeywordAlternateBlock returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Alternative' | kw= 'alternative' ) ;
    public final AntlrDatatypeRuleToken ruleKeywordAlternateBlock() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalUcm4iot.g:3802:2: ( (kw= 'Alternative' | kw= 'alternative' ) )
            // InternalUcm4iot.g:3803:2: (kw= 'Alternative' | kw= 'alternative' )
            {
            // InternalUcm4iot.g:3803:2: (kw= 'Alternative' | kw= 'alternative' )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==72) ) {
                alt75=1;
            }
            else if ( (LA75_0==73) ) {
                alt75=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;
            }
            switch (alt75) {
                case 1 :
                    // InternalUcm4iot.g:3804:3: kw= 'Alternative'
                    {
                    kw=(Token)match(input,72,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAlternateBlockAccess().getAlternativeKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:3810:3: kw= 'alternative'
                    {
                    kw=(Token)match(input,73,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAlternateBlockAccess().getAlternativeKeyword_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKeywordAlternateBlock"


    // $ANTLR start "entryRuleKeywordExceptionalBlock"
    // InternalUcm4iot.g:3819:1: entryRuleKeywordExceptionalBlock returns [String current=null] : iv_ruleKeywordExceptionalBlock= ruleKeywordExceptionalBlock EOF ;
    public final String entryRuleKeywordExceptionalBlock() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKeywordExceptionalBlock = null;


        try {
            // InternalUcm4iot.g:3819:63: (iv_ruleKeywordExceptionalBlock= ruleKeywordExceptionalBlock EOF )
            // InternalUcm4iot.g:3820:2: iv_ruleKeywordExceptionalBlock= ruleKeywordExceptionalBlock EOF
            {
             newCompositeNode(grammarAccess.getKeywordExceptionalBlockRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleKeywordExceptionalBlock=ruleKeywordExceptionalBlock();

            state._fsp--;

             current =iv_ruleKeywordExceptionalBlock.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKeywordExceptionalBlock"


    // $ANTLR start "ruleKeywordExceptionalBlock"
    // InternalUcm4iot.g:3826:1: ruleKeywordExceptionalBlock returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Exception' | kw= 'exception' ) ;
    public final AntlrDatatypeRuleToken ruleKeywordExceptionalBlock() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalUcm4iot.g:3832:2: ( (kw= 'Exception' | kw= 'exception' ) )
            // InternalUcm4iot.g:3833:2: (kw= 'Exception' | kw= 'exception' )
            {
            // InternalUcm4iot.g:3833:2: (kw= 'Exception' | kw= 'exception' )
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==74) ) {
                alt76=1;
            }
            else if ( (LA76_0==75) ) {
                alt76=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;
            }
            switch (alt76) {
                case 1 :
                    // InternalUcm4iot.g:3834:3: kw= 'Exception'
                    {
                    kw=(Token)match(input,74,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordExceptionalBlockAccess().getExceptionKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:3840:3: kw= 'exception'
                    {
                    kw=(Token)match(input,75,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordExceptionalBlockAccess().getExceptionKeyword_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKeywordExceptionalBlock"


    // $ANTLR start "entryRuleKeywordChildListBegins"
    // InternalUcm4iot.g:3849:1: entryRuleKeywordChildListBegins returns [String current=null] : iv_ruleKeywordChildListBegins= ruleKeywordChildListBegins EOF ;
    public final String entryRuleKeywordChildListBegins() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKeywordChildListBegins = null;


        try {
            // InternalUcm4iot.g:3849:62: (iv_ruleKeywordChildListBegins= ruleKeywordChildListBegins EOF )
            // InternalUcm4iot.g:3850:2: iv_ruleKeywordChildListBegins= ruleKeywordChildListBegins EOF
            {
             newCompositeNode(grammarAccess.getKeywordChildListBeginsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleKeywordChildListBegins=ruleKeywordChildListBegins();

            state._fsp--;

             current =iv_ruleKeywordChildListBegins.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKeywordChildListBegins"


    // $ANTLR start "ruleKeywordChildListBegins"
    // InternalUcm4iot.g:3856:1: ruleKeywordChildListBegins returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= 'Nested' | kw= 'nested' ) (kw= 'Extensions' | kw= 'extensions' ) (kw= 'Begin' | kw= 'begin' ) ) ;
    public final AntlrDatatypeRuleToken ruleKeywordChildListBegins() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalUcm4iot.g:3862:2: ( ( (kw= 'Nested' | kw= 'nested' ) (kw= 'Extensions' | kw= 'extensions' ) (kw= 'Begin' | kw= 'begin' ) ) )
            // InternalUcm4iot.g:3863:2: ( (kw= 'Nested' | kw= 'nested' ) (kw= 'Extensions' | kw= 'extensions' ) (kw= 'Begin' | kw= 'begin' ) )
            {
            // InternalUcm4iot.g:3863:2: ( (kw= 'Nested' | kw= 'nested' ) (kw= 'Extensions' | kw= 'extensions' ) (kw= 'Begin' | kw= 'begin' ) )
            // InternalUcm4iot.g:3864:3: (kw= 'Nested' | kw= 'nested' ) (kw= 'Extensions' | kw= 'extensions' ) (kw= 'Begin' | kw= 'begin' )
            {
            // InternalUcm4iot.g:3864:3: (kw= 'Nested' | kw= 'nested' )
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==76) ) {
                alt77=1;
            }
            else if ( (LA77_0==77) ) {
                alt77=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 77, 0, input);

                throw nvae;
            }
            switch (alt77) {
                case 1 :
                    // InternalUcm4iot.g:3865:4: kw= 'Nested'
                    {
                    kw=(Token)match(input,76,FOLLOW_56); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordChildListBeginsAccess().getNestedKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:3871:4: kw= 'nested'
                    {
                    kw=(Token)match(input,77,FOLLOW_56); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordChildListBeginsAccess().getNestedKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalUcm4iot.g:3877:3: (kw= 'Extensions' | kw= 'extensions' )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==70) ) {
                alt78=1;
            }
            else if ( (LA78_0==71) ) {
                alt78=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;
            }
            switch (alt78) {
                case 1 :
                    // InternalUcm4iot.g:3878:4: kw= 'Extensions'
                    {
                    kw=(Token)match(input,70,FOLLOW_57); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordChildListBeginsAccess().getExtensionsKeyword_1_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:3884:4: kw= 'extensions'
                    {
                    kw=(Token)match(input,71,FOLLOW_57); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordChildListBeginsAccess().getExtensionsKeyword_1_1());
                    			

                    }
                    break;

            }

            // InternalUcm4iot.g:3890:3: (kw= 'Begin' | kw= 'begin' )
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==78) ) {
                alt79=1;
            }
            else if ( (LA79_0==79) ) {
                alt79=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;
            }
            switch (alt79) {
                case 1 :
                    // InternalUcm4iot.g:3891:4: kw= 'Begin'
                    {
                    kw=(Token)match(input,78,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordChildListBeginsAccess().getBeginKeyword_2_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:3897:4: kw= 'begin'
                    {
                    kw=(Token)match(input,79,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordChildListBeginsAccess().getBeginKeyword_2_1());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKeywordChildListBegins"


    // $ANTLR start "entryRuleKeywordChildListEnds"
    // InternalUcm4iot.g:3907:1: entryRuleKeywordChildListEnds returns [String current=null] : iv_ruleKeywordChildListEnds= ruleKeywordChildListEnds EOF ;
    public final String entryRuleKeywordChildListEnds() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKeywordChildListEnds = null;


        try {
            // InternalUcm4iot.g:3907:60: (iv_ruleKeywordChildListEnds= ruleKeywordChildListEnds EOF )
            // InternalUcm4iot.g:3908:2: iv_ruleKeywordChildListEnds= ruleKeywordChildListEnds EOF
            {
             newCompositeNode(grammarAccess.getKeywordChildListEndsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleKeywordChildListEnds=ruleKeywordChildListEnds();

            state._fsp--;

             current =iv_ruleKeywordChildListEnds.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKeywordChildListEnds"


    // $ANTLR start "ruleKeywordChildListEnds"
    // InternalUcm4iot.g:3914:1: ruleKeywordChildListEnds returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= 'Nested' | kw= 'nested' ) (kw= 'Extensions' | kw= 'extensions' ) (kw= 'Ends' | kw= 'ends' ) ) ;
    public final AntlrDatatypeRuleToken ruleKeywordChildListEnds() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalUcm4iot.g:3920:2: ( ( (kw= 'Nested' | kw= 'nested' ) (kw= 'Extensions' | kw= 'extensions' ) (kw= 'Ends' | kw= 'ends' ) ) )
            // InternalUcm4iot.g:3921:2: ( (kw= 'Nested' | kw= 'nested' ) (kw= 'Extensions' | kw= 'extensions' ) (kw= 'Ends' | kw= 'ends' ) )
            {
            // InternalUcm4iot.g:3921:2: ( (kw= 'Nested' | kw= 'nested' ) (kw= 'Extensions' | kw= 'extensions' ) (kw= 'Ends' | kw= 'ends' ) )
            // InternalUcm4iot.g:3922:3: (kw= 'Nested' | kw= 'nested' ) (kw= 'Extensions' | kw= 'extensions' ) (kw= 'Ends' | kw= 'ends' )
            {
            // InternalUcm4iot.g:3922:3: (kw= 'Nested' | kw= 'nested' )
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==76) ) {
                alt80=1;
            }
            else if ( (LA80_0==77) ) {
                alt80=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;
            }
            switch (alt80) {
                case 1 :
                    // InternalUcm4iot.g:3923:4: kw= 'Nested'
                    {
                    kw=(Token)match(input,76,FOLLOW_56); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordChildListEndsAccess().getNestedKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:3929:4: kw= 'nested'
                    {
                    kw=(Token)match(input,77,FOLLOW_56); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordChildListEndsAccess().getNestedKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalUcm4iot.g:3935:3: (kw= 'Extensions' | kw= 'extensions' )
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==70) ) {
                alt81=1;
            }
            else if ( (LA81_0==71) ) {
                alt81=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 81, 0, input);

                throw nvae;
            }
            switch (alt81) {
                case 1 :
                    // InternalUcm4iot.g:3936:4: kw= 'Extensions'
                    {
                    kw=(Token)match(input,70,FOLLOW_58); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordChildListEndsAccess().getExtensionsKeyword_1_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:3942:4: kw= 'extensions'
                    {
                    kw=(Token)match(input,71,FOLLOW_58); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordChildListEndsAccess().getExtensionsKeyword_1_1());
                    			

                    }
                    break;

            }

            // InternalUcm4iot.g:3948:3: (kw= 'Ends' | kw= 'ends' )
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==80) ) {
                alt82=1;
            }
            else if ( (LA82_0==81) ) {
                alt82=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;
            }
            switch (alt82) {
                case 1 :
                    // InternalUcm4iot.g:3949:4: kw= 'Ends'
                    {
                    kw=(Token)match(input,80,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordChildListEndsAccess().getEndsKeyword_2_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:3955:4: kw= 'ends'
                    {
                    kw=(Token)match(input,81,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordChildListEndsAccess().getEndsKeyword_2_1());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKeywordChildListEnds"


    // $ANTLR start "entryRuleKeywordPrimaryActor"
    // InternalUcm4iot.g:3965:1: entryRuleKeywordPrimaryActor returns [String current=null] : iv_ruleKeywordPrimaryActor= ruleKeywordPrimaryActor EOF ;
    public final String entryRuleKeywordPrimaryActor() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKeywordPrimaryActor = null;


        try {
            // InternalUcm4iot.g:3965:59: (iv_ruleKeywordPrimaryActor= ruleKeywordPrimaryActor EOF )
            // InternalUcm4iot.g:3966:2: iv_ruleKeywordPrimaryActor= ruleKeywordPrimaryActor EOF
            {
             newCompositeNode(grammarAccess.getKeywordPrimaryActorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleKeywordPrimaryActor=ruleKeywordPrimaryActor();

            state._fsp--;

             current =iv_ruleKeywordPrimaryActor.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKeywordPrimaryActor"


    // $ANTLR start "ruleKeywordPrimaryActor"
    // InternalUcm4iot.g:3972:1: ruleKeywordPrimaryActor returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= 'Primary' | kw= 'primary' ) (kw= 'Actor' | kw= 'actor' ) ) ;
    public final AntlrDatatypeRuleToken ruleKeywordPrimaryActor() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalUcm4iot.g:3978:2: ( ( (kw= 'Primary' | kw= 'primary' ) (kw= 'Actor' | kw= 'actor' ) ) )
            // InternalUcm4iot.g:3979:2: ( (kw= 'Primary' | kw= 'primary' ) (kw= 'Actor' | kw= 'actor' ) )
            {
            // InternalUcm4iot.g:3979:2: ( (kw= 'Primary' | kw= 'primary' ) (kw= 'Actor' | kw= 'actor' ) )
            // InternalUcm4iot.g:3980:3: (kw= 'Primary' | kw= 'primary' ) (kw= 'Actor' | kw= 'actor' )
            {
            // InternalUcm4iot.g:3980:3: (kw= 'Primary' | kw= 'primary' )
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==82) ) {
                alt83=1;
            }
            else if ( (LA83_0==83) ) {
                alt83=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 83, 0, input);

                throw nvae;
            }
            switch (alt83) {
                case 1 :
                    // InternalUcm4iot.g:3981:4: kw= 'Primary'
                    {
                    kw=(Token)match(input,82,FOLLOW_59); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordPrimaryActorAccess().getPrimaryKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:3987:4: kw= 'primary'
                    {
                    kw=(Token)match(input,83,FOLLOW_59); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordPrimaryActorAccess().getPrimaryKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalUcm4iot.g:3993:3: (kw= 'Actor' | kw= 'actor' )
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==84) ) {
                alt84=1;
            }
            else if ( (LA84_0==85) ) {
                alt84=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 84, 0, input);

                throw nvae;
            }
            switch (alt84) {
                case 1 :
                    // InternalUcm4iot.g:3994:4: kw= 'Actor'
                    {
                    kw=(Token)match(input,84,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordPrimaryActorAccess().getActorKeyword_1_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:4000:4: kw= 'actor'
                    {
                    kw=(Token)match(input,85,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordPrimaryActorAccess().getActorKeyword_1_1());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKeywordPrimaryActor"


    // $ANTLR start "entryRuleKeywordSecondaryActor"
    // InternalUcm4iot.g:4010:1: entryRuleKeywordSecondaryActor returns [String current=null] : iv_ruleKeywordSecondaryActor= ruleKeywordSecondaryActor EOF ;
    public final String entryRuleKeywordSecondaryActor() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKeywordSecondaryActor = null;


        try {
            // InternalUcm4iot.g:4010:61: (iv_ruleKeywordSecondaryActor= ruleKeywordSecondaryActor EOF )
            // InternalUcm4iot.g:4011:2: iv_ruleKeywordSecondaryActor= ruleKeywordSecondaryActor EOF
            {
             newCompositeNode(grammarAccess.getKeywordSecondaryActorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleKeywordSecondaryActor=ruleKeywordSecondaryActor();

            state._fsp--;

             current =iv_ruleKeywordSecondaryActor.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKeywordSecondaryActor"


    // $ANTLR start "ruleKeywordSecondaryActor"
    // InternalUcm4iot.g:4017:1: ruleKeywordSecondaryActor returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= 'Secondary' | kw= 'secondary' ) (kw= 'Actor' | kw= 'actor' ) ) ;
    public final AntlrDatatypeRuleToken ruleKeywordSecondaryActor() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalUcm4iot.g:4023:2: ( ( (kw= 'Secondary' | kw= 'secondary' ) (kw= 'Actor' | kw= 'actor' ) ) )
            // InternalUcm4iot.g:4024:2: ( (kw= 'Secondary' | kw= 'secondary' ) (kw= 'Actor' | kw= 'actor' ) )
            {
            // InternalUcm4iot.g:4024:2: ( (kw= 'Secondary' | kw= 'secondary' ) (kw= 'Actor' | kw= 'actor' ) )
            // InternalUcm4iot.g:4025:3: (kw= 'Secondary' | kw= 'secondary' ) (kw= 'Actor' | kw= 'actor' )
            {
            // InternalUcm4iot.g:4025:3: (kw= 'Secondary' | kw= 'secondary' )
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==86) ) {
                alt85=1;
            }
            else if ( (LA85_0==87) ) {
                alt85=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;
            }
            switch (alt85) {
                case 1 :
                    // InternalUcm4iot.g:4026:4: kw= 'Secondary'
                    {
                    kw=(Token)match(input,86,FOLLOW_59); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordSecondaryActorAccess().getSecondaryKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:4032:4: kw= 'secondary'
                    {
                    kw=(Token)match(input,87,FOLLOW_59); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordSecondaryActorAccess().getSecondaryKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalUcm4iot.g:4038:3: (kw= 'Actor' | kw= 'actor' )
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==84) ) {
                alt86=1;
            }
            else if ( (LA86_0==85) ) {
                alt86=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;
            }
            switch (alt86) {
                case 1 :
                    // InternalUcm4iot.g:4039:4: kw= 'Actor'
                    {
                    kw=(Token)match(input,84,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordSecondaryActorAccess().getActorKeyword_1_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:4045:4: kw= 'actor'
                    {
                    kw=(Token)match(input,85,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordSecondaryActorAccess().getActorKeyword_1_1());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKeywordSecondaryActor"


    // $ANTLR start "entryRuleKeywordFacilitatorActor"
    // InternalUcm4iot.g:4055:1: entryRuleKeywordFacilitatorActor returns [String current=null] : iv_ruleKeywordFacilitatorActor= ruleKeywordFacilitatorActor EOF ;
    public final String entryRuleKeywordFacilitatorActor() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKeywordFacilitatorActor = null;


        try {
            // InternalUcm4iot.g:4055:63: (iv_ruleKeywordFacilitatorActor= ruleKeywordFacilitatorActor EOF )
            // InternalUcm4iot.g:4056:2: iv_ruleKeywordFacilitatorActor= ruleKeywordFacilitatorActor EOF
            {
             newCompositeNode(grammarAccess.getKeywordFacilitatorActorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleKeywordFacilitatorActor=ruleKeywordFacilitatorActor();

            state._fsp--;

             current =iv_ruleKeywordFacilitatorActor.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKeywordFacilitatorActor"


    // $ANTLR start "ruleKeywordFacilitatorActor"
    // InternalUcm4iot.g:4062:1: ruleKeywordFacilitatorActor returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= 'Facilitator' | kw= 'facilitator' ) (kw= 'Actor' | kw= 'actor' ) ) ;
    public final AntlrDatatypeRuleToken ruleKeywordFacilitatorActor() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalUcm4iot.g:4068:2: ( ( (kw= 'Facilitator' | kw= 'facilitator' ) (kw= 'Actor' | kw= 'actor' ) ) )
            // InternalUcm4iot.g:4069:2: ( (kw= 'Facilitator' | kw= 'facilitator' ) (kw= 'Actor' | kw= 'actor' ) )
            {
            // InternalUcm4iot.g:4069:2: ( (kw= 'Facilitator' | kw= 'facilitator' ) (kw= 'Actor' | kw= 'actor' ) )
            // InternalUcm4iot.g:4070:3: (kw= 'Facilitator' | kw= 'facilitator' ) (kw= 'Actor' | kw= 'actor' )
            {
            // InternalUcm4iot.g:4070:3: (kw= 'Facilitator' | kw= 'facilitator' )
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==88) ) {
                alt87=1;
            }
            else if ( (LA87_0==89) ) {
                alt87=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;
            }
            switch (alt87) {
                case 1 :
                    // InternalUcm4iot.g:4071:4: kw= 'Facilitator'
                    {
                    kw=(Token)match(input,88,FOLLOW_59); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordFacilitatorActorAccess().getFacilitatorKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:4077:4: kw= 'facilitator'
                    {
                    kw=(Token)match(input,89,FOLLOW_59); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordFacilitatorActorAccess().getFacilitatorKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalUcm4iot.g:4083:3: (kw= 'Actor' | kw= 'actor' )
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==84) ) {
                alt88=1;
            }
            else if ( (LA88_0==85) ) {
                alt88=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);

                throw nvae;
            }
            switch (alt88) {
                case 1 :
                    // InternalUcm4iot.g:4084:4: kw= 'Actor'
                    {
                    kw=(Token)match(input,84,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordFacilitatorActorAccess().getActorKeyword_1_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:4090:4: kw= 'actor'
                    {
                    kw=(Token)match(input,85,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordFacilitatorActorAccess().getActorKeyword_1_1());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKeywordFacilitatorActor"


    // $ANTLR start "entryRuleKeywordException"
    // InternalUcm4iot.g:4100:1: entryRuleKeywordException returns [String current=null] : iv_ruleKeywordException= ruleKeywordException EOF ;
    public final String entryRuleKeywordException() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKeywordException = null;


        try {
            // InternalUcm4iot.g:4100:56: (iv_ruleKeywordException= ruleKeywordException EOF )
            // InternalUcm4iot.g:4101:2: iv_ruleKeywordException= ruleKeywordException EOF
            {
             newCompositeNode(grammarAccess.getKeywordExceptionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleKeywordException=ruleKeywordException();

            state._fsp--;

             current =iv_ruleKeywordException.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKeywordException"


    // $ANTLR start "ruleKeywordException"
    // InternalUcm4iot.g:4107:1: ruleKeywordException returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_KeywordEnvironmentException_0= ruleKeywordEnvironmentException | this_KeywordNetworkException_1= ruleKeywordNetworkException | this_KeywordHardwareException_2= ruleKeywordHardwareException | this_KeywordSoftwareException_3= ruleKeywordSoftwareException ) ;
    public final AntlrDatatypeRuleToken ruleKeywordException() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_KeywordEnvironmentException_0 = null;

        AntlrDatatypeRuleToken this_KeywordNetworkException_1 = null;

        AntlrDatatypeRuleToken this_KeywordHardwareException_2 = null;

        AntlrDatatypeRuleToken this_KeywordSoftwareException_3 = null;



        	enterRule();

        try {
            // InternalUcm4iot.g:4113:2: ( (this_KeywordEnvironmentException_0= ruleKeywordEnvironmentException | this_KeywordNetworkException_1= ruleKeywordNetworkException | this_KeywordHardwareException_2= ruleKeywordHardwareException | this_KeywordSoftwareException_3= ruleKeywordSoftwareException ) )
            // InternalUcm4iot.g:4114:2: (this_KeywordEnvironmentException_0= ruleKeywordEnvironmentException | this_KeywordNetworkException_1= ruleKeywordNetworkException | this_KeywordHardwareException_2= ruleKeywordHardwareException | this_KeywordSoftwareException_3= ruleKeywordSoftwareException )
            {
            // InternalUcm4iot.g:4114:2: (this_KeywordEnvironmentException_0= ruleKeywordEnvironmentException | this_KeywordNetworkException_1= ruleKeywordNetworkException | this_KeywordHardwareException_2= ruleKeywordHardwareException | this_KeywordSoftwareException_3= ruleKeywordSoftwareException )
            int alt89=4;
            switch ( input.LA(1) ) {
            case 90:
                {
                alt89=1;
                }
                break;
            case 91:
                {
                alt89=2;
                }
                break;
            case 92:
                {
                alt89=3;
                }
                break;
            case 93:
                {
                alt89=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 89, 0, input);

                throw nvae;
            }

            switch (alt89) {
                case 1 :
                    // InternalUcm4iot.g:4115:3: this_KeywordEnvironmentException_0= ruleKeywordEnvironmentException
                    {

                    			newCompositeNode(grammarAccess.getKeywordExceptionAccess().getKeywordEnvironmentExceptionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_KeywordEnvironmentException_0=ruleKeywordEnvironmentException();

                    state._fsp--;


                    			current.merge(this_KeywordEnvironmentException_0);
                    		

                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:4126:3: this_KeywordNetworkException_1= ruleKeywordNetworkException
                    {

                    			newCompositeNode(grammarAccess.getKeywordExceptionAccess().getKeywordNetworkExceptionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_KeywordNetworkException_1=ruleKeywordNetworkException();

                    state._fsp--;


                    			current.merge(this_KeywordNetworkException_1);
                    		

                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalUcm4iot.g:4137:3: this_KeywordHardwareException_2= ruleKeywordHardwareException
                    {

                    			newCompositeNode(grammarAccess.getKeywordExceptionAccess().getKeywordHardwareExceptionParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_KeywordHardwareException_2=ruleKeywordHardwareException();

                    state._fsp--;


                    			current.merge(this_KeywordHardwareException_2);
                    		

                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalUcm4iot.g:4148:3: this_KeywordSoftwareException_3= ruleKeywordSoftwareException
                    {

                    			newCompositeNode(grammarAccess.getKeywordExceptionAccess().getKeywordSoftwareExceptionParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_KeywordSoftwareException_3=ruleKeywordSoftwareException();

                    state._fsp--;


                    			current.merge(this_KeywordSoftwareException_3);
                    		

                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKeywordException"


    // $ANTLR start "entryRuleKeywordEnvironmentException"
    // InternalUcm4iot.g:4162:1: entryRuleKeywordEnvironmentException returns [String current=null] : iv_ruleKeywordEnvironmentException= ruleKeywordEnvironmentException EOF ;
    public final String entryRuleKeywordEnvironmentException() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKeywordEnvironmentException = null;


        try {
            // InternalUcm4iot.g:4162:67: (iv_ruleKeywordEnvironmentException= ruleKeywordEnvironmentException EOF )
            // InternalUcm4iot.g:4163:2: iv_ruleKeywordEnvironmentException= ruleKeywordEnvironmentException EOF
            {
             newCompositeNode(grammarAccess.getKeywordEnvironmentExceptionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleKeywordEnvironmentException=ruleKeywordEnvironmentException();

            state._fsp--;

             current =iv_ruleKeywordEnvironmentException.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKeywordEnvironmentException"


    // $ANTLR start "ruleKeywordEnvironmentException"
    // InternalUcm4iot.g:4169:1: ruleKeywordEnvironmentException returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'ENVIRONMENT_EXCEPTION' ;
    public final AntlrDatatypeRuleToken ruleKeywordEnvironmentException() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalUcm4iot.g:4175:2: (kw= 'ENVIRONMENT_EXCEPTION' )
            // InternalUcm4iot.g:4176:2: kw= 'ENVIRONMENT_EXCEPTION'
            {
            kw=(Token)match(input,90,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getKeywordEnvironmentExceptionAccess().getENVIRONMENT_EXCEPTIONKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKeywordEnvironmentException"


    // $ANTLR start "entryRuleKeywordNetworkException"
    // InternalUcm4iot.g:4184:1: entryRuleKeywordNetworkException returns [String current=null] : iv_ruleKeywordNetworkException= ruleKeywordNetworkException EOF ;
    public final String entryRuleKeywordNetworkException() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKeywordNetworkException = null;


        try {
            // InternalUcm4iot.g:4184:63: (iv_ruleKeywordNetworkException= ruleKeywordNetworkException EOF )
            // InternalUcm4iot.g:4185:2: iv_ruleKeywordNetworkException= ruleKeywordNetworkException EOF
            {
             newCompositeNode(grammarAccess.getKeywordNetworkExceptionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleKeywordNetworkException=ruleKeywordNetworkException();

            state._fsp--;

             current =iv_ruleKeywordNetworkException.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKeywordNetworkException"


    // $ANTLR start "ruleKeywordNetworkException"
    // InternalUcm4iot.g:4191:1: ruleKeywordNetworkException returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'NETWORK_EXCEPTION' ;
    public final AntlrDatatypeRuleToken ruleKeywordNetworkException() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalUcm4iot.g:4197:2: (kw= 'NETWORK_EXCEPTION' )
            // InternalUcm4iot.g:4198:2: kw= 'NETWORK_EXCEPTION'
            {
            kw=(Token)match(input,91,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getKeywordNetworkExceptionAccess().getNETWORK_EXCEPTIONKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKeywordNetworkException"


    // $ANTLR start "entryRuleKeywordHardwareException"
    // InternalUcm4iot.g:4206:1: entryRuleKeywordHardwareException returns [String current=null] : iv_ruleKeywordHardwareException= ruleKeywordHardwareException EOF ;
    public final String entryRuleKeywordHardwareException() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKeywordHardwareException = null;


        try {
            // InternalUcm4iot.g:4206:64: (iv_ruleKeywordHardwareException= ruleKeywordHardwareException EOF )
            // InternalUcm4iot.g:4207:2: iv_ruleKeywordHardwareException= ruleKeywordHardwareException EOF
            {
             newCompositeNode(grammarAccess.getKeywordHardwareExceptionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleKeywordHardwareException=ruleKeywordHardwareException();

            state._fsp--;

             current =iv_ruleKeywordHardwareException.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKeywordHardwareException"


    // $ANTLR start "ruleKeywordHardwareException"
    // InternalUcm4iot.g:4213:1: ruleKeywordHardwareException returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'HARDWARE_EXCEPTION' ;
    public final AntlrDatatypeRuleToken ruleKeywordHardwareException() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalUcm4iot.g:4219:2: (kw= 'HARDWARE_EXCEPTION' )
            // InternalUcm4iot.g:4220:2: kw= 'HARDWARE_EXCEPTION'
            {
            kw=(Token)match(input,92,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getKeywordHardwareExceptionAccess().getHARDWARE_EXCEPTIONKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKeywordHardwareException"


    // $ANTLR start "entryRuleKeywordSoftwareException"
    // InternalUcm4iot.g:4228:1: entryRuleKeywordSoftwareException returns [String current=null] : iv_ruleKeywordSoftwareException= ruleKeywordSoftwareException EOF ;
    public final String entryRuleKeywordSoftwareException() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKeywordSoftwareException = null;


        try {
            // InternalUcm4iot.g:4228:64: (iv_ruleKeywordSoftwareException= ruleKeywordSoftwareException EOF )
            // InternalUcm4iot.g:4229:2: iv_ruleKeywordSoftwareException= ruleKeywordSoftwareException EOF
            {
             newCompositeNode(grammarAccess.getKeywordSoftwareExceptionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleKeywordSoftwareException=ruleKeywordSoftwareException();

            state._fsp--;

             current =iv_ruleKeywordSoftwareException.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKeywordSoftwareException"


    // $ANTLR start "ruleKeywordSoftwareException"
    // InternalUcm4iot.g:4235:1: ruleKeywordSoftwareException returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'SOFTWARE_EXCEPTION' ;
    public final AntlrDatatypeRuleToken ruleKeywordSoftwareException() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalUcm4iot.g:4241:2: (kw= 'SOFTWARE_EXCEPTION' )
            // InternalUcm4iot.g:4242:2: kw= 'SOFTWARE_EXCEPTION'
            {
            kw=(Token)match(input,93,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getKeywordSoftwareExceptionAccess().getSOFTWARE_EXCEPTIONKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKeywordSoftwareException"


    // $ANTLR start "entryRuleKeywordOutcomeEnds"
    // InternalUcm4iot.g:4250:1: entryRuleKeywordOutcomeEnds returns [String current=null] : iv_ruleKeywordOutcomeEnds= ruleKeywordOutcomeEnds EOF ;
    public final String entryRuleKeywordOutcomeEnds() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKeywordOutcomeEnds = null;


        try {
            // InternalUcm4iot.g:4250:58: (iv_ruleKeywordOutcomeEnds= ruleKeywordOutcomeEnds EOF )
            // InternalUcm4iot.g:4251:2: iv_ruleKeywordOutcomeEnds= ruleKeywordOutcomeEnds EOF
            {
             newCompositeNode(grammarAccess.getKeywordOutcomeEndsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleKeywordOutcomeEnds=ruleKeywordOutcomeEnds();

            state._fsp--;

             current =iv_ruleKeywordOutcomeEnds.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKeywordOutcomeEnds"


    // $ANTLR start "ruleKeywordOutcomeEnds"
    // InternalUcm4iot.g:4257:1: ruleKeywordOutcomeEnds returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= 'Use' | kw= 'use' ) (kw= 'Case' | kw= 'case' ) (kw= 'Ends' | kw= 'ends' ) (kw= 'In' | kw= 'in' ) ) ;
    public final AntlrDatatypeRuleToken ruleKeywordOutcomeEnds() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalUcm4iot.g:4263:2: ( ( (kw= 'Use' | kw= 'use' ) (kw= 'Case' | kw= 'case' ) (kw= 'Ends' | kw= 'ends' ) (kw= 'In' | kw= 'in' ) ) )
            // InternalUcm4iot.g:4264:2: ( (kw= 'Use' | kw= 'use' ) (kw= 'Case' | kw= 'case' ) (kw= 'Ends' | kw= 'ends' ) (kw= 'In' | kw= 'in' ) )
            {
            // InternalUcm4iot.g:4264:2: ( (kw= 'Use' | kw= 'use' ) (kw= 'Case' | kw= 'case' ) (kw= 'Ends' | kw= 'ends' ) (kw= 'In' | kw= 'in' ) )
            // InternalUcm4iot.g:4265:3: (kw= 'Use' | kw= 'use' ) (kw= 'Case' | kw= 'case' ) (kw= 'Ends' | kw= 'ends' ) (kw= 'In' | kw= 'in' )
            {
            // InternalUcm4iot.g:4265:3: (kw= 'Use' | kw= 'use' )
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==38) ) {
                alt90=1;
            }
            else if ( (LA90_0==39) ) {
                alt90=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 90, 0, input);

                throw nvae;
            }
            switch (alt90) {
                case 1 :
                    // InternalUcm4iot.g:4266:4: kw= 'Use'
                    {
                    kw=(Token)match(input,38,FOLLOW_49); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordOutcomeEndsAccess().getUseKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:4272:4: kw= 'use'
                    {
                    kw=(Token)match(input,39,FOLLOW_49); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordOutcomeEndsAccess().getUseKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalUcm4iot.g:4278:3: (kw= 'Case' | kw= 'case' )
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==40) ) {
                alt91=1;
            }
            else if ( (LA91_0==41) ) {
                alt91=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 91, 0, input);

                throw nvae;
            }
            switch (alt91) {
                case 1 :
                    // InternalUcm4iot.g:4279:4: kw= 'Case'
                    {
                    kw=(Token)match(input,40,FOLLOW_58); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordOutcomeEndsAccess().getCaseKeyword_1_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:4285:4: kw= 'case'
                    {
                    kw=(Token)match(input,41,FOLLOW_58); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordOutcomeEndsAccess().getCaseKeyword_1_1());
                    			

                    }
                    break;

            }

            // InternalUcm4iot.g:4291:3: (kw= 'Ends' | kw= 'ends' )
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==80) ) {
                alt92=1;
            }
            else if ( (LA92_0==81) ) {
                alt92=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 92, 0, input);

                throw nvae;
            }
            switch (alt92) {
                case 1 :
                    // InternalUcm4iot.g:4292:4: kw= 'Ends'
                    {
                    kw=(Token)match(input,80,FOLLOW_60); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordOutcomeEndsAccess().getEndsKeyword_2_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:4298:4: kw= 'ends'
                    {
                    kw=(Token)match(input,81,FOLLOW_60); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordOutcomeEndsAccess().getEndsKeyword_2_1());
                    			

                    }
                    break;

            }

            // InternalUcm4iot.g:4304:3: (kw= 'In' | kw= 'in' )
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==94) ) {
                alt93=1;
            }
            else if ( (LA93_0==95) ) {
                alt93=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 93, 0, input);

                throw nvae;
            }
            switch (alt93) {
                case 1 :
                    // InternalUcm4iot.g:4305:4: kw= 'In'
                    {
                    kw=(Token)match(input,94,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordOutcomeEndsAccess().getInKeyword_3_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:4311:4: kw= 'in'
                    {
                    kw=(Token)match(input,95,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordOutcomeEndsAccess().getInKeyword_3_1());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKeywordOutcomeEnds"


    // $ANTLR start "entryRuleKeywordOutcomeCont"
    // InternalUcm4iot.g:4321:1: entryRuleKeywordOutcomeCont returns [String current=null] : iv_ruleKeywordOutcomeCont= ruleKeywordOutcomeCont EOF ;
    public final String entryRuleKeywordOutcomeCont() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKeywordOutcomeCont = null;


        try {
            // InternalUcm4iot.g:4321:58: (iv_ruleKeywordOutcomeCont= ruleKeywordOutcomeCont EOF )
            // InternalUcm4iot.g:4322:2: iv_ruleKeywordOutcomeCont= ruleKeywordOutcomeCont EOF
            {
             newCompositeNode(grammarAccess.getKeywordOutcomeContRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleKeywordOutcomeCont=ruleKeywordOutcomeCont();

            state._fsp--;

             current =iv_ruleKeywordOutcomeCont.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKeywordOutcomeCont"


    // $ANTLR start "ruleKeywordOutcomeCont"
    // InternalUcm4iot.g:4328:1: ruleKeywordOutcomeCont returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= 'Use' | kw= 'use' ) (kw= 'Case' | kw= 'case' ) (kw= 'Continues' | kw= 'continues' ) (kw= 'At' | kw= 'at' ) (kw= 'Step' | kw= 'step' ) ) ;
    public final AntlrDatatypeRuleToken ruleKeywordOutcomeCont() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalUcm4iot.g:4334:2: ( ( (kw= 'Use' | kw= 'use' ) (kw= 'Case' | kw= 'case' ) (kw= 'Continues' | kw= 'continues' ) (kw= 'At' | kw= 'at' ) (kw= 'Step' | kw= 'step' ) ) )
            // InternalUcm4iot.g:4335:2: ( (kw= 'Use' | kw= 'use' ) (kw= 'Case' | kw= 'case' ) (kw= 'Continues' | kw= 'continues' ) (kw= 'At' | kw= 'at' ) (kw= 'Step' | kw= 'step' ) )
            {
            // InternalUcm4iot.g:4335:2: ( (kw= 'Use' | kw= 'use' ) (kw= 'Case' | kw= 'case' ) (kw= 'Continues' | kw= 'continues' ) (kw= 'At' | kw= 'at' ) (kw= 'Step' | kw= 'step' ) )
            // InternalUcm4iot.g:4336:3: (kw= 'Use' | kw= 'use' ) (kw= 'Case' | kw= 'case' ) (kw= 'Continues' | kw= 'continues' ) (kw= 'At' | kw= 'at' ) (kw= 'Step' | kw= 'step' )
            {
            // InternalUcm4iot.g:4336:3: (kw= 'Use' | kw= 'use' )
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==38) ) {
                alt94=1;
            }
            else if ( (LA94_0==39) ) {
                alt94=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 94, 0, input);

                throw nvae;
            }
            switch (alt94) {
                case 1 :
                    // InternalUcm4iot.g:4337:4: kw= 'Use'
                    {
                    kw=(Token)match(input,38,FOLLOW_49); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordOutcomeContAccess().getUseKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:4343:4: kw= 'use'
                    {
                    kw=(Token)match(input,39,FOLLOW_49); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordOutcomeContAccess().getUseKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalUcm4iot.g:4349:3: (kw= 'Case' | kw= 'case' )
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==40) ) {
                alt95=1;
            }
            else if ( (LA95_0==41) ) {
                alt95=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 95, 0, input);

                throw nvae;
            }
            switch (alt95) {
                case 1 :
                    // InternalUcm4iot.g:4350:4: kw= 'Case'
                    {
                    kw=(Token)match(input,40,FOLLOW_61); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordOutcomeContAccess().getCaseKeyword_1_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:4356:4: kw= 'case'
                    {
                    kw=(Token)match(input,41,FOLLOW_61); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordOutcomeContAccess().getCaseKeyword_1_1());
                    			

                    }
                    break;

            }

            // InternalUcm4iot.g:4362:3: (kw= 'Continues' | kw= 'continues' )
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==96) ) {
                alt96=1;
            }
            else if ( (LA96_0==97) ) {
                alt96=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 96, 0, input);

                throw nvae;
            }
            switch (alt96) {
                case 1 :
                    // InternalUcm4iot.g:4363:4: kw= 'Continues'
                    {
                    kw=(Token)match(input,96,FOLLOW_62); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordOutcomeContAccess().getContinuesKeyword_2_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:4369:4: kw= 'continues'
                    {
                    kw=(Token)match(input,97,FOLLOW_62); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordOutcomeContAccess().getContinuesKeyword_2_1());
                    			

                    }
                    break;

            }

            // InternalUcm4iot.g:4375:3: (kw= 'At' | kw= 'at' )
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==98) ) {
                alt97=1;
            }
            else if ( (LA97_0==99) ) {
                alt97=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 97, 0, input);

                throw nvae;
            }
            switch (alt97) {
                case 1 :
                    // InternalUcm4iot.g:4376:4: kw= 'At'
                    {
                    kw=(Token)match(input,98,FOLLOW_63); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordOutcomeContAccess().getAtKeyword_3_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:4382:4: kw= 'at'
                    {
                    kw=(Token)match(input,99,FOLLOW_63); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordOutcomeContAccess().getAtKeyword_3_1());
                    			

                    }
                    break;

            }

            // InternalUcm4iot.g:4388:3: (kw= 'Step' | kw= 'step' )
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==100) ) {
                alt98=1;
            }
            else if ( (LA98_0==101) ) {
                alt98=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 98, 0, input);

                throw nvae;
            }
            switch (alt98) {
                case 1 :
                    // InternalUcm4iot.g:4389:4: kw= 'Step'
                    {
                    kw=(Token)match(input,100,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordOutcomeContAccess().getStepKeyword_4_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:4395:4: kw= 'step'
                    {
                    kw=(Token)match(input,101,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getKeywordOutcomeContAccess().getStepKeyword_4_1());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKeywordOutcomeCont"


    // $ANTLR start "entryRuleNone"
    // InternalUcm4iot.g:4405:1: entryRuleNone returns [String current=null] : iv_ruleNone= ruleNone EOF ;
    public final String entryRuleNone() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNone = null;


        try {
            // InternalUcm4iot.g:4405:44: (iv_ruleNone= ruleNone EOF )
            // InternalUcm4iot.g:4406:2: iv_ruleNone= ruleNone EOF
            {
             newCompositeNode(grammarAccess.getNoneRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNone=ruleNone();

            state._fsp--;

             current =iv_ruleNone.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNone"


    // $ANTLR start "ruleNone"
    // InternalUcm4iot.g:4412:1: ruleNone returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'None' | kw= 'none' ) ;
    public final AntlrDatatypeRuleToken ruleNone() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalUcm4iot.g:4418:2: ( (kw= 'None' | kw= 'none' ) )
            // InternalUcm4iot.g:4419:2: (kw= 'None' | kw= 'none' )
            {
            // InternalUcm4iot.g:4419:2: (kw= 'None' | kw= 'none' )
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==102) ) {
                alt99=1;
            }
            else if ( (LA99_0==103) ) {
                alt99=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 99, 0, input);

                throw nvae;
            }
            switch (alt99) {
                case 1 :
                    // InternalUcm4iot.g:4420:3: kw= 'None'
                    {
                    kw=(Token)match(input,102,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getNoneAccess().getNoneKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:4426:3: kw= 'none'
                    {
                    kw=(Token)match(input,103,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getNoneAccess().getNoneKeyword_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNone"


    // $ANTLR start "entryRuleNotApplicable"
    // InternalUcm4iot.g:4435:1: entryRuleNotApplicable returns [String current=null] : iv_ruleNotApplicable= ruleNotApplicable EOF ;
    public final String entryRuleNotApplicable() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNotApplicable = null;


        try {
            // InternalUcm4iot.g:4435:53: (iv_ruleNotApplicable= ruleNotApplicable EOF )
            // InternalUcm4iot.g:4436:2: iv_ruleNotApplicable= ruleNotApplicable EOF
            {
             newCompositeNode(grammarAccess.getNotApplicableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNotApplicable=ruleNotApplicable();

            state._fsp--;

             current =iv_ruleNotApplicable.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNotApplicable"


    // $ANTLR start "ruleNotApplicable"
    // InternalUcm4iot.g:4442:1: ruleNotApplicable returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'N/A' | kw= 'n/a' ) ;
    public final AntlrDatatypeRuleToken ruleNotApplicable() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalUcm4iot.g:4448:2: ( (kw= 'N/A' | kw= 'n/a' ) )
            // InternalUcm4iot.g:4449:2: (kw= 'N/A' | kw= 'n/a' )
            {
            // InternalUcm4iot.g:4449:2: (kw= 'N/A' | kw= 'n/a' )
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==104) ) {
                alt100=1;
            }
            else if ( (LA100_0==105) ) {
                alt100=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 100, 0, input);

                throw nvae;
            }
            switch (alt100) {
                case 1 :
                    // InternalUcm4iot.g:4450:3: kw= 'N/A'
                    {
                    kw=(Token)match(input,104,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getNotApplicableAccess().getNAKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:4456:3: kw= 'n/a'
                    {
                    kw=(Token)match(input,105,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getNotApplicableAccess().getNAKeyword_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNotApplicable"


    // $ANTLR start "ruleLevel"
    // InternalUcm4iot.g:4465:1: ruleLevel returns [Enumerator current=null] : ( (enumLiteral_0= 'SUMMARY' ) | (enumLiteral_1= 'USER_GOAL' ) | (enumLiteral_2= 'SUB_FUNCTION' ) ) ;
    public final Enumerator ruleLevel() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalUcm4iot.g:4471:2: ( ( (enumLiteral_0= 'SUMMARY' ) | (enumLiteral_1= 'USER_GOAL' ) | (enumLiteral_2= 'SUB_FUNCTION' ) ) )
            // InternalUcm4iot.g:4472:2: ( (enumLiteral_0= 'SUMMARY' ) | (enumLiteral_1= 'USER_GOAL' ) | (enumLiteral_2= 'SUB_FUNCTION' ) )
            {
            // InternalUcm4iot.g:4472:2: ( (enumLiteral_0= 'SUMMARY' ) | (enumLiteral_1= 'USER_GOAL' ) | (enumLiteral_2= 'SUB_FUNCTION' ) )
            int alt101=3;
            switch ( input.LA(1) ) {
            case 106:
                {
                alt101=1;
                }
                break;
            case 107:
                {
                alt101=2;
                }
                break;
            case 108:
                {
                alt101=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 101, 0, input);

                throw nvae;
            }

            switch (alt101) {
                case 1 :
                    // InternalUcm4iot.g:4473:3: (enumLiteral_0= 'SUMMARY' )
                    {
                    // InternalUcm4iot.g:4473:3: (enumLiteral_0= 'SUMMARY' )
                    // InternalUcm4iot.g:4474:4: enumLiteral_0= 'SUMMARY'
                    {
                    enumLiteral_0=(Token)match(input,106,FOLLOW_2); 

                    				current = grammarAccess.getLevelAccess().getSUMMARYEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getLevelAccess().getSUMMARYEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:4481:3: (enumLiteral_1= 'USER_GOAL' )
                    {
                    // InternalUcm4iot.g:4481:3: (enumLiteral_1= 'USER_GOAL' )
                    // InternalUcm4iot.g:4482:4: enumLiteral_1= 'USER_GOAL'
                    {
                    enumLiteral_1=(Token)match(input,107,FOLLOW_2); 

                    				current = grammarAccess.getLevelAccess().getUSER_GOALEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getLevelAccess().getUSER_GOALEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalUcm4iot.g:4489:3: (enumLiteral_2= 'SUB_FUNCTION' )
                    {
                    // InternalUcm4iot.g:4489:3: (enumLiteral_2= 'SUB_FUNCTION' )
                    // InternalUcm4iot.g:4490:4: enumLiteral_2= 'SUB_FUNCTION'
                    {
                    enumLiteral_2=(Token)match(input,108,FOLLOW_2); 

                    				current = grammarAccess.getLevelAccess().getSUBFUNCTIONEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getLevelAccess().getSUBFUNCTIONEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLevel"


    // $ANTLR start "ruleOutcomeEndings"
    // InternalUcm4iot.g:4500:1: ruleOutcomeEndings returns [Enumerator current=null] : ( (enumLiteral_0= 'SUCCESS' ) | (enumLiteral_1= 'FAILURE' ) | (enumLiteral_2= 'DEGRADED' ) | (enumLiteral_3= 'ABANDONED' ) ) ;
    public final Enumerator ruleOutcomeEndings() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalUcm4iot.g:4506:2: ( ( (enumLiteral_0= 'SUCCESS' ) | (enumLiteral_1= 'FAILURE' ) | (enumLiteral_2= 'DEGRADED' ) | (enumLiteral_3= 'ABANDONED' ) ) )
            // InternalUcm4iot.g:4507:2: ( (enumLiteral_0= 'SUCCESS' ) | (enumLiteral_1= 'FAILURE' ) | (enumLiteral_2= 'DEGRADED' ) | (enumLiteral_3= 'ABANDONED' ) )
            {
            // InternalUcm4iot.g:4507:2: ( (enumLiteral_0= 'SUCCESS' ) | (enumLiteral_1= 'FAILURE' ) | (enumLiteral_2= 'DEGRADED' ) | (enumLiteral_3= 'ABANDONED' ) )
            int alt102=4;
            switch ( input.LA(1) ) {
            case 109:
                {
                alt102=1;
                }
                break;
            case 110:
                {
                alt102=2;
                }
                break;
            case 111:
                {
                alt102=3;
                }
                break;
            case 112:
                {
                alt102=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 102, 0, input);

                throw nvae;
            }

            switch (alt102) {
                case 1 :
                    // InternalUcm4iot.g:4508:3: (enumLiteral_0= 'SUCCESS' )
                    {
                    // InternalUcm4iot.g:4508:3: (enumLiteral_0= 'SUCCESS' )
                    // InternalUcm4iot.g:4509:4: enumLiteral_0= 'SUCCESS'
                    {
                    enumLiteral_0=(Token)match(input,109,FOLLOW_2); 

                    				current = grammarAccess.getOutcomeEndingsAccess().getSUCCESSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getOutcomeEndingsAccess().getSUCCESSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalUcm4iot.g:4516:3: (enumLiteral_1= 'FAILURE' )
                    {
                    // InternalUcm4iot.g:4516:3: (enumLiteral_1= 'FAILURE' )
                    // InternalUcm4iot.g:4517:4: enumLiteral_1= 'FAILURE'
                    {
                    enumLiteral_1=(Token)match(input,110,FOLLOW_2); 

                    				current = grammarAccess.getOutcomeEndingsAccess().getFAILUREEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getOutcomeEndingsAccess().getFAILUREEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalUcm4iot.g:4524:3: (enumLiteral_2= 'DEGRADED' )
                    {
                    // InternalUcm4iot.g:4524:3: (enumLiteral_2= 'DEGRADED' )
                    // InternalUcm4iot.g:4525:4: enumLiteral_2= 'DEGRADED'
                    {
                    enumLiteral_2=(Token)match(input,111,FOLLOW_2); 

                    				current = grammarAccess.getOutcomeEndingsAccess().getDEGRADEDEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getOutcomeEndingsAccess().getDEGRADEDEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalUcm4iot.g:4532:3: (enumLiteral_3= 'ABANDONED' )
                    {
                    // InternalUcm4iot.g:4532:3: (enumLiteral_3= 'ABANDONED' )
                    // InternalUcm4iot.g:4533:4: enumLiteral_3= 'ABANDONED'
                    {
                    enumLiteral_3=(Token)match(input,112,FOLLOW_2); 

                    				current = grammarAccess.getOutcomeEndingsAccess().getABANDONEDEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getOutcomeEndingsAccess().getABANDONEDEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOutcomeEndings"

    // Delegated rules


    protected DFA14 dfa14 = new DFA14(this);
    protected DFA26 dfa26 = new DFA26(this);
    protected DFA30 dfa30 = new DFA30(this);
    protected DFA34 dfa34 = new DFA34(this);
    protected DFA39 dfa39 = new DFA39(this);
    protected DFA44 dfa44 = new DFA44(this);
    static final String dfa_1s = "\13\uffff";
    static final String dfa_2s = "\1\1\12\uffff";
    static final String dfa_3s = "\1\54\12\uffff";
    static final String dfa_4s = "\1\131\12\uffff";
    static final String dfa_5s = "\1\uffff\1\12\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11";
    static final String dfa_6s = "\1\0\12\uffff}>";
    static final String[] dfa_7s = {
            "\2\2\2\3\2\4\2\5\2\6\2\7\10\uffff\2\1\20\uffff\2\10\2\uffff\2\11\2\12",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()+ loopback of 298:6: ( ({...}? => ( ({...}? => ( ruleKeywordScope otherlv_5= ':' ( (lv_scope_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordIntention otherlv_8= ':' ( (lv_intent_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordLevel otherlv_11= ':' ( (lv_level_12_0= ruleLevel ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordMultiplicity otherlv_14= ':' ( (lv_multiplicity_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrecondition otherlv_17= ':' ( (lv_precondition_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPostcondition otherlv_20= ':' ( (lv_postcondition_21_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrimaryActor otherlv_23= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordSecondaryActor otherlv_28= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordFacilitatorActor otherlv_35= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA14_0 = input.LA(1);

                         
                        int index14_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA14_0==EOF||(LA14_0>=64 && LA14_0<=65)) ) {s = 1;}

                        else if ( LA14_0 >= 44 && LA14_0 <= 45 && getUnorderedGroupHelper().canSelect(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3(), 0) ) {s = 2;}

                        else if ( LA14_0 >= 46 && LA14_0 <= 47 && getUnorderedGroupHelper().canSelect(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3(), 1) ) {s = 3;}

                        else if ( LA14_0 >= 48 && LA14_0 <= 49 && getUnorderedGroupHelper().canSelect(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3(), 2) ) {s = 4;}

                        else if ( LA14_0 >= 50 && LA14_0 <= 51 && getUnorderedGroupHelper().canSelect(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3(), 3) ) {s = 5;}

                        else if ( LA14_0 >= 52 && LA14_0 <= 53 && getUnorderedGroupHelper().canSelect(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3(), 4) ) {s = 6;}

                        else if ( LA14_0 >= 54 && LA14_0 <= 55 && getUnorderedGroupHelper().canSelect(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3(), 5) ) {s = 7;}

                        else if ( LA14_0 >= 82 && LA14_0 <= 83 && getUnorderedGroupHelper().canSelect(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3(), 6) ) {s = 8;}

                        else if ( LA14_0 >= 86 && LA14_0 <= 87 && getUnorderedGroupHelper().canSelect(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3(), 7) ) {s = 9;}

                        else if ( LA14_0 >= 88 && LA14_0 <= 89 && getUnorderedGroupHelper().canSelect(grammarAccess.getExceptionalUseCaseAccess().getUnorderedGroup_3(), 8) ) {s = 10;}

                         
                        input.seek(index14_0);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 14, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_8s = "\15\uffff";
    static final String dfa_9s = "\1\1\14\uffff";
    static final String dfa_10s = "\1\52\14\uffff";
    static final String dfa_11s = "\1\131\14\uffff";
    static final String dfa_12s = "\1\uffff\1\14\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13";
    static final String dfa_13s = "\1\0\14\uffff}>";
    static final String[] dfa_14s = {
            "\2\13\2\2\2\3\2\4\2\5\2\6\2\7\2\uffff\2\14\4\uffff\2\1\20\uffff\2\10\2\uffff\2\11\2\12",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final short[] dfa_9 = DFA.unpackEncodedString(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final char[] dfa_11 = DFA.unpackEncodedStringToUnsignedChars(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[][] dfa_14 = unpackEncodedStringArray(dfa_14s);

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "()+ loopback of 839:6: ( ({...}? => ( ({...}? => ( ruleKeywordScope otherlv_5= ':' ( (lv_scope_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordIntention otherlv_8= ':' ( (lv_intent_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordLevel otherlv_11= ':' ( (lv_level_12_0= ruleLevel ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordMultiplicity otherlv_14= ':' ( (lv_multiplicity_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrecondition otherlv_17= ':' ( (lv_precondition_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPostcondition otherlv_20= ':' ( (lv_postcondition_21_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordPrimaryActor otherlv_23= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_primaryActor_26_0= rulePrimaryActor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordSecondaryActor otherlv_28= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_secondaryActors_31_0= ruleSecondaryActor ) ) (otherlv_32= ',' ( (lv_secondaryActors_33_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordFacilitatorActor otherlv_35= ':' ( ( ruleNotApplicable | ruleNone ) | ( ( (lv_facilitatorActors_38_0= ruleSecondaryActor ) ) (otherlv_39= ',' ( (lv_facilitatorActors_40_0= ruleSecondaryActor ) ) )* ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordHandlerClass otherlv_42= ':' ( ( ruleNotApplicable | ruleNone ) | ( (lv_handlerClass_45_0= RULE_ID ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ruleKeywordContextException otherlv_47= ':' ( (lv_contextExceptions_48_0= ruleContextExceptionMapping ) ) (otherlv_49= ',' ( (lv_contextExceptions_50_0= ruleContextExceptionMapping ) ) )* ) ) ) ) )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA26_0 = input.LA(1);

                         
                        int index26_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA26_0==EOF||(LA26_0>=64 && LA26_0<=65)) ) {s = 1;}

                        else if ( LA26_0 >= 44 && LA26_0 <= 45 && getUnorderedGroupHelper().canSelect(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3(), 0) ) {s = 2;}

                        else if ( LA26_0 >= 46 && LA26_0 <= 47 && getUnorderedGroupHelper().canSelect(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3(), 1) ) {s = 3;}

                        else if ( LA26_0 >= 48 && LA26_0 <= 49 && getUnorderedGroupHelper().canSelect(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3(), 2) ) {s = 4;}

                        else if ( LA26_0 >= 50 && LA26_0 <= 51 && getUnorderedGroupHelper().canSelect(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3(), 3) ) {s = 5;}

                        else if ( LA26_0 >= 52 && LA26_0 <= 53 && getUnorderedGroupHelper().canSelect(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3(), 4) ) {s = 6;}

                        else if ( LA26_0 >= 54 && LA26_0 <= 55 && getUnorderedGroupHelper().canSelect(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3(), 5) ) {s = 7;}

                        else if ( LA26_0 >= 82 && LA26_0 <= 83 && getUnorderedGroupHelper().canSelect(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3(), 6) ) {s = 8;}

                        else if ( LA26_0 >= 86 && LA26_0 <= 87 && getUnorderedGroupHelper().canSelect(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3(), 7) ) {s = 9;}

                        else if ( LA26_0 >= 88 && LA26_0 <= 89 && getUnorderedGroupHelper().canSelect(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3(), 8) ) {s = 10;}

                        else if ( LA26_0 >= 42 && LA26_0 <= 43 && getUnorderedGroupHelper().canSelect(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3(), 9) ) {s = 11;}

                        else if ( LA26_0 >= 58 && LA26_0 <= 59 && getUnorderedGroupHelper().canSelect(grammarAccess.getHandlerUseCaseAccess().getUnorderedGroup_3(), 10) ) {s = 12;}

                         
                        input.seek(index26_0);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 26, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_15s = "\14\uffff";
    static final String dfa_16s = "\1\7\1\uffff\1\7\1\4\1\uffff\2\7\2\4\1\7\2\4";
    static final String dfa_17s = "\1\22\1\uffff\1\22\1\25\1\uffff\1\7\1\22\2\25\1\7\1\15\1\25";
    static final String dfa_18s = "\1\uffff\1\1\2\uffff\1\2\7\uffff";
    static final String dfa_19s = "\14\uffff}>";
    static final String[] dfa_20s = {
            "\1\1\12\uffff\1\2",
            "",
            "\1\3\12\uffff\1\4",
            "\1\4\16\uffff\1\6\1\uffff\1\5",
            "",
            "\1\7",
            "\1\10\12\uffff\1\4",
            "\1\4\16\uffff\1\6\1\uffff\1\5",
            "\1\4\17\uffff\1\12\1\11",
            "\1\13",
            "\1\1\10\uffff\1\4",
            "\1\4\17\uffff\1\12\1\11"
    };

    static final short[] dfa_15 = DFA.unpackEncodedString(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final char[] dfa_17 = DFA.unpackEncodedStringToUnsignedChars(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[] dfa_19 = DFA.unpackEncodedString(dfa_19s);
    static final short[][] dfa_20 = unpackEncodedStringArray(dfa_20s);

    class DFA30 extends DFA {

        public DFA30(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 30;
            this.eot = dfa_15;
            this.eof = dfa_15;
            this.min = dfa_16;
            this.max = dfa_17;
            this.accept = dfa_18;
            this.special = dfa_19;
            this.transition = dfa_20;
        }
        public String getDescription() {
            return "1611:3: ( ( ( ruleStepNumber ) ) | ( ( (lv_hasRangedRef_3_0= '(' ) ) ( ( ruleStepNumber ) ) otherlv_5= '-' ( ( ruleStepNumber ) ) otherlv_7= ')' ) )";
        }
    }

    class DFA34 extends DFA {

        public DFA34(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 34;
            this.eot = dfa_15;
            this.eof = dfa_15;
            this.min = dfa_16;
            this.max = dfa_17;
            this.accept = dfa_18;
            this.special = dfa_19;
            this.transition = dfa_20;
        }
        public String getDescription() {
            return "1800:3: ( ( ( ruleStepNumber ) ) | ( ( (lv_hasRangedRef_3_0= '(' ) ) ( ( ruleStepNumber ) ) otherlv_5= '-' ( ( ruleStepNumber ) ) otherlv_7= ')' ) )";
        }
    }
    static final String dfa_21s = "\24\uffff";
    static final String dfa_22s = "\1\5\1\4\1\7\1\uffff\1\5\1\25\1\23\1\4\2\uffff\1\5\2\7\1\4\1\23\1\24\1\25\1\7\1\4\1\24";
    static final String dfa_23s = "\1\22\1\25\1\7\1\uffff\1\30\3\25\2\uffff\1\30\2\7\4\25\1\7\1\4\1\25";
    static final String dfa_24s = "\3\uffff\1\3\4\uffff\1\2\1\1\12\uffff";
    static final String dfa_25s = "\24\uffff}>";
    static final String[] dfa_26s = {
            "\2\3\1\1\12\uffff\1\2",
            "\1\5\20\uffff\1\4",
            "\1\6",
            "",
            "\2\11\1\7\16\uffff\1\10\1\uffff\1\11",
            "\1\12",
            "\1\14\1\uffff\1\13",
            "\1\5\20\uffff\1\4",
            "",
            "",
            "\2\11\1\15\16\uffff\1\10\1\uffff\1\11",
            "\1\16",
            "\1\17",
            "\1\20\20\uffff\1\12",
            "\1\14\1\uffff\1\13",
            "\1\22\1\21",
            "\1\12",
            "\1\23",
            "\1\5",
            "\1\22\1\21"
    };

    static final short[] dfa_21 = DFA.unpackEncodedString(dfa_21s);
    static final char[] dfa_22 = DFA.unpackEncodedStringToUnsignedChars(dfa_22s);
    static final char[] dfa_23 = DFA.unpackEncodedStringToUnsignedChars(dfa_23s);
    static final short[] dfa_24 = DFA.unpackEncodedString(dfa_24s);
    static final short[] dfa_25 = DFA.unpackEncodedString(dfa_25s);
    static final short[][] dfa_26 = unpackEncodedStringArray(dfa_26s);

    class DFA39 extends DFA {

        public DFA39(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 39;
            this.eot = dfa_21;
            this.eof = dfa_21;
            this.min = dfa_22;
            this.max = dfa_23;
            this.accept = dfa_24;
            this.special = dfa_25;
            this.transition = dfa_26;
        }
        public String getDescription() {
            return "2108:2: (this_InteractionStep_0= ruleInteractionStep | this_InvocationStep_1= ruleInvocationStep | this_ConditionControlStep_2= ruleConditionControlStep )";
        }
    }
    static final String dfa_27s = "\6\uffff";
    static final String dfa_28s = "\1\uffff\1\4\3\uffff\1\4";
    static final String dfa_29s = "\1\7\1\4\1\uffff\1\5\1\uffff\1\4";
    static final String dfa_30s = "\1\22\1\115\1\uffff\1\30\1\uffff\1\115";
    static final String dfa_31s = "\2\uffff\1\2\1\uffff\1\1\1\uffff";
    static final String dfa_32s = "\6\uffff}>";
    static final String[] dfa_33s = {
            "\1\1\12\uffff\1\2",
            "\1\2\10\uffff\1\4\5\uffff\2\4\1\3\20\uffff\2\4\2\uffff\2\4\34\uffff\6\4",
            "",
            "\2\4\1\5\16\uffff\1\4\1\uffff\1\4",
            "",
            "\1\2\10\uffff\1\4\5\uffff\2\4\1\3\20\uffff\2\4\2\uffff\2\4\34\uffff\6\4"
    };

    static final short[] dfa_27 = DFA.unpackEncodedString(dfa_27s);
    static final short[] dfa_28 = DFA.unpackEncodedString(dfa_28s);
    static final char[] dfa_29 = DFA.unpackEncodedStringToUnsignedChars(dfa_29s);
    static final char[] dfa_30 = DFA.unpackEncodedStringToUnsignedChars(dfa_30s);
    static final short[] dfa_31 = DFA.unpackEncodedString(dfa_31s);
    static final short[] dfa_32 = DFA.unpackEncodedString(dfa_32s);
    static final short[][] dfa_33 = unpackEncodedStringArray(dfa_33s);

    class DFA44 extends DFA {

        public DFA44(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 44;
            this.eot = dfa_27;
            this.eof = dfa_28;
            this.min = dfa_29;
            this.max = dfa_30;
            this.accept = dfa_31;
            this.special = dfa_32;
            this.transition = dfa_33;
        }
        public String getDescription() {
            return "2411:2: (this_MainStepNumber_0= ruleMainStepNumber | this_ExtensionStepNumber_1= ruleExtensionStepNumber )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000C00000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00000CC000000002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x00000000000400E0L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000002L,0x00000000000000C0L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000F00L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x00FFF00000000000L,0x0000000003CC0000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x00FFF00000000002L,0x0000000003CC0000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000000L,0x00001C0000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000018000010L,0x000003C000000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x00000003F8000010L,0x000003C000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x00FFF00000010002L,0x0000000003CC0000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0CFFFC0000000000L,0x0000000003CC0000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0CFFFC0000000002L,0x0000000003CC0000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0CFFFC0000010002L,0x0000000003CC0000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000010L,0x000003C000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x000000C0000400E0L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000F00L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000040080L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x000000C0000400E0L,0x0000000000003000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000000L,0x0000000000003F00L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000000L,0x0001E00000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000001000060L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000200012L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000000L,0x000000003C000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000030000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x000000C000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0300000000000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x3000000000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0xC000000000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000002L,0x000000000000003CL});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000030L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000000L,0x00000000000000C0L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000000L,0x000000000000C000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000000L,0x0000000000030000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000000L,0x0000000000300000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000000L,0x00000000C0000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000000L,0x0000000300000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000000L,0x0000000C00000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000000L,0x0000003000000000L});

}
