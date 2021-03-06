/***************************************************************************
 *  Copyright (C) 2010 by H-Store Project                                  *
 *  Brown University                                                       *
 *  Massachusetts Institute of Technology                                  *
 *  Yale University                                                        *
 *                                                                         *
 *  Andy Pavlo (pavlo@cs.brown.edu)                                        *
 *  http://www.cs.brown.edu/~pavlo/                                        *
 *                                                                         *
 *  Visawee Angkanawaraphan (visawee@cs.brown.edu)                         *
 *  http://www.cs.brown.edu/~visawee/                                      *
 *                                                                         *
 *  Permission is hereby granted, free of charge, to any person obtaining  *
 *  a copy of this software and associated documentation files (the        *
 *  "Software"), to deal in the Software without restriction, including    *
 *  without limitation the rights to use, copy, modify, merge, publish,    *
 *  distribute, sublicense, and/or sell copies of the Software, and to     *
 *  permit persons to whom the Software is furnished to do so, subject to  *
 *  the following conditions:                                              *
 *                                                                         *
 *  The above copyright notice and this permission notice shall be         *
 *  included in all copies or substantial portions of the Software.        *
 *                                                                         *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,        *
 *  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF     *
 *  MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. *
 *  IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR      *
 *  OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,  *
 *  ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR  *
 *  OTHER DEALINGS IN THE SOFTWARE.                                        *
 ***************************************************************************/
package edu.brown.benchmark.auctionmark;

import java.util.*;


public abstract class AuctionMarkConstants {
    
    // ----------------------------------------------------------------
    // STORED PROCEDURE INFORMATION
    // ----------------------------------------------------------------
    
    // Non-standard txns
    public static final int FREQUENCY_CLOSE_AUCTIONS    = -1; // called at regular intervals
    public static final boolean ENABLE_CLOSE_AUCTIONS   = true;
    
    // Regular Txn Mix
    public static final int FREQUENCY_GET_ITEM              = 25;
    public static final int FREQUENCY_GET_USER_INFO         = 15;
    public static final int FREQUENCY_NEW_BID               = 20;
    public static final int FREQUENCY_NEW_COMMENT           = 5;  
    public static final int FREQUENCY_NEW_COMMENT_RESPONSE  = 5;
    public static final int FREQUENCY_NEW_FEEDBACK          = 5;
    public static final int FREQUENCY_NEW_ITEM              = 10;
    public static final int FREQUENCY_NEW_PURCHASE          = 5;
    public static final int FREQUENCY_UPDATE_ITEM           = 10;
    
//    public static final int FREQUENCY_GET_ITEM              = 50;
//    public static final int FREQUENCY_GET_USER_INFO         = 0;
//    public static final int FREQUENCY_NEW_BID               = 50;
//    public static final int FREQUENCY_NEW_COMMENT           = 0;  
//    public static final int FREQUENCY_NEW_COMMENT_RESPONSE  = 0;
//    public static final int FREQUENCY_NEW_FEEDBACK          = 0;
//    public static final int FREQUENCY_NEW_ITEM              = 0;
//    public static final int FREQUENCY_NEW_PURCHASE          = 0;
//    public static final int FREQUENCY_UPDATE_ITEM           = 0;
    
    // ----------------------------------------------------------------
    // DEFAULT TABLE SIZES
    // ----------------------------------------------------------------
    
    public static final long TABLESIZE_REGION                   = 75;
    public static final long TABLESIZE_GLOBAL_ATTRIBUTE_GROUP   = 100;
    public static final long TABLESIZE_GLOBAL_ATTRIBUTE_VALUE   = 1; // HACK: IGNORE
    public static final long TABLESIZE_GLOBAL_ATTRIBUTE_VALUE_PER_GROUP = 10;
    public static final long TABLESIZE_USER                     = 100000;
    
    // ----------------------------------------------------------------
    // USER PARAMETERS
    // ----------------------------------------------------------------
    
    public static final int USER_MIN_ATTRIBUTES = 0;
    public static final int USER_MAX_ATTRIBUTES = 5;
    
    public static final long USER_MIN_BALANCE   = 1000;
    public static final long USER_MAX_BALANCE   = 100000;
    
    public static final long USER_MIN_RATING   = 0;
    public static final long USER_MAX_RATING   = 10000;
    
    // ----------------------------------------------------------------
    // ITEM PARAMETERS
    // ----------------------------------------------------------------
    
    public enum ItemStatus {
        OPEN                    (false),
        ENDING_SOON             (true), // Only used internally
        WAITING_FOR_PURCHASE    (false),
        CLOSED                  (false);
        
        private final boolean internal;
        
        private ItemStatus(boolean internal) {
            this.internal = internal;
        }
        public boolean isInternal() {
            return internal;
        }
        public static ItemStatus get(long idx) {
            return (values()[(int)idx]);
        }
    }
    
    public static final int ITEM_MIN_INITIAL_PRICE = 1;
    public static final int ITEM_MAX_INITIAL_PRICE = 1000;
    public static final int ITEM_MIN_ITEMS_PER_SELLER = 0;
    public static final int ITEM_MAX_ITEMS_PER_SELLER = 10000;
    public static final int ITEM_MIN_BIDS_PER_DAY = 0;
    public static final int ITEM_MAX_BIDS_PER_DAY = 10;
    public static final int ITEM_MIN_WATCHES_PER_DAY = 0;
    public static final int ITEM_MAX_WATCHES_PER_DAY = 20;
    public static final int ITEM_MIN_IMAGES = 1;
    public static final int ITEM_MAX_IMAGES = 10;
    public static final int ITEM_MIN_COMMENTS = 0;
    public static final int ITEM_MAX_COMMENTS = 5;
    public static final int ITEM_MIN_GLOBAL_ATTRS = 1;
    public static final int ITEM_MAX_GLOBAL_ATTRS = 10;
    
    /** When an item receives a bid we will increase its price by this amount */
    public static final float ITEM_BID_PERCENT_STEP = 0.025f;
    
    /** How long should we wait before the buyer purchases an item that they won */
    public static final int ITEM_MAX_PURCHASE_DURATION_DAYS = 7;
    
    /** Duration in days that expired bids are preserved */
    public static final int ITEM_PRESERVE_DAYS = 7;
    
    /** The duration in days for each auction */
    public static final int ITEM_MAX_DURATION_DAYS = 10;
    public static final int ITEM_MAX_PURCHASE_DAY = 7;
    
    /**
     * This defines the maximum size of a small cache of ItemIds that
     * we maintain in the benchmark profile. For some procedures, the client will 
     * ItemIds out of this cache and use them as txn parameters 
     */
    public static final int ITEM_ID_CACHE_SIZE  = 1000;
    
    // ----------------------------------------------------------------
    // DEFAULT BATCH SIZES
    // ----------------------------------------------------------------
    
    public static final long BATCHSIZE_REGION                   = 5000;
    public static final long BATCHSIZE_GLOBAL_ATTRIBUTE_GROUP   = 5000;
    public static final long BATCHSIZE_GLOBAL_ATTRIBUTE_VALUE   = 5000;
    public static final long BATCHSIZE_CATEGORY                 = 5000;
    public static final long BATCHSIZE_USER                     = 1000;
    public static final long BATCHSIZE_USER_ATTRIBUTES          = 5000;
    public static final long BATCHSIZE_USER_FEEDBACK            = 1000;
    public static final long BATCHSIZE_USER_ITEM                = 5000;
    public static final long BATCHSIZE_USER_WATCH               = 5000;
    public static final long BATCHSIZE_ITEM                     = 2000;
    public static final long BATCHSIZE_ITEM_ATTRIBUTE           = 5000;
    public static final long BATCHSIZE_ITEM_IMAGE               = 5000;
    public static final long BATCHSIZE_ITEM_COMMENT             = 1000;
    public static final long BATCHSIZE_ITEM_BID                 = 5000;
    public static final long BATCHSIZE_ITEM_MAX_BID             = 5000;
    public static final long BATCHSIZE_ITEM_PURCHASE            = 5000;
    
    public static final long BATCHSIZE_CLOSE_AUCTIONS_UPDATES   = 50;
    
    // ----------------------------------------------------------------
    // TABLE NAMES
    // ----------------------------------------------------------------
    public static final String TABLENAME_CONFIG_PROFILE         = "CONFIG_PROFILE";
    public static final String TABLENAME_REGION                 = "REGION";
    public static final String TABLENAME_USER                   = "USER";
    public static final String TABLENAME_USER_ATTRIBUTES        = "USER_ATTRIBUTES";
    public static final String TABLENAME_USER_ITEM              = "USER_ITEM";
    public static final String TABLENAME_USER_WATCH             = "USER_WATCH";
    public static final String TABLENAME_USER_FEEDBACK          = "USER_FEEDBACK";
    public static final String TABLENAME_CATEGORY               = "CATEGORY";
    public static final String TABLENAME_GLOBAL_ATTRIBUTE_GROUP = "GLOBAL_ATTRIBUTE_GROUP";
    public static final String TABLENAME_GLOBAL_ATTRIBUTE_VALUE = "GLOBAL_ATTRIBUTE_VALUE";
    public static final String TABLENAME_ITEM                   = "ITEM";
    public static final String TABLENAME_ITEM_ATTRIBUTE         = "ITEM_ATTRIBUTE";
    public static final String TABLENAME_ITEM_IMAGE             = "ITEM_IMAGE";
    public static final String TABLENAME_ITEM_COMMENT           = "ITEM_COMMENT";
    public static final String TABLENAME_ITEM_BID               = "ITEM_BID";
    public static final String TABLENAME_ITEM_MAX_BID           = "ITEM_MAX_BID";
    public static final String TABLENAME_ITEM_PURCHASE          = "ITEM_PURCHASE";

    public static final String TABLENAMES[] = {
        AuctionMarkConstants.TABLENAME_REGION,
        AuctionMarkConstants.TABLENAME_CATEGORY,
        AuctionMarkConstants.TABLENAME_GLOBAL_ATTRIBUTE_GROUP,
        AuctionMarkConstants.TABLENAME_GLOBAL_ATTRIBUTE_VALUE,
        AuctionMarkConstants.TABLENAME_USER,
        AuctionMarkConstants.TABLENAME_USER_ATTRIBUTES,
        AuctionMarkConstants.TABLENAME_USER_ITEM,
        AuctionMarkConstants.TABLENAME_USER_WATCH,
        AuctionMarkConstants.TABLENAME_USER_FEEDBACK,
        AuctionMarkConstants.TABLENAME_ITEM,
        AuctionMarkConstants.TABLENAME_ITEM_ATTRIBUTE,
        AuctionMarkConstants.TABLENAME_ITEM_IMAGE,
        AuctionMarkConstants.TABLENAME_ITEM_COMMENT,
        AuctionMarkConstants.TABLENAME_ITEM_BID,
        AuctionMarkConstants.TABLENAME_ITEM_MAX_BID,
        AuctionMarkConstants.TABLENAME_ITEM_PURCHASE,
    };
    
    // ----------------------------------------------------------------
    // TABLE DATA SOURCES
    // ----------------------------------------------------------------
    
    // If a table exists in this set, then the number of tuples loaded into the table
    // should not be modified by the scale factor
    public static final Collection<String> FIXED_TABLES = new HashSet<String>();
    static {
        FIXED_TABLES.add(AuctionMarkConstants.TABLENAME_REGION);
        FIXED_TABLES.add(AuctionMarkConstants.TABLENAME_GLOBAL_ATTRIBUTE_GROUP);
        FIXED_TABLES.add(AuctionMarkConstants.TABLENAME_GLOBAL_ATTRIBUTE_VALUE);
    }
    
    public static final Collection<String> DYNAMIC_TABLES = new HashSet<String>();
    static {
        DYNAMIC_TABLES.add(AuctionMarkConstants.TABLENAME_USER_ATTRIBUTES);
        DYNAMIC_TABLES.add(AuctionMarkConstants.TABLENAME_ITEM_IMAGE);
        DYNAMIC_TABLES.add(AuctionMarkConstants.TABLENAME_ITEM_ATTRIBUTE);
        DYNAMIC_TABLES.add(AuctionMarkConstants.TABLENAME_ITEM_COMMENT);
        DYNAMIC_TABLES.add(AuctionMarkConstants.TABLENAME_USER_FEEDBACK);
        DYNAMIC_TABLES.add(AuctionMarkConstants.TABLENAME_ITEM_BID);
        DYNAMIC_TABLES.add(AuctionMarkConstants.TABLENAME_ITEM_MAX_BID);
        DYNAMIC_TABLES.add(AuctionMarkConstants.TABLENAME_ITEM_PURCHASE);
        DYNAMIC_TABLES.add(AuctionMarkConstants.TABLENAME_USER_ITEM);
        DYNAMIC_TABLES.add(AuctionMarkConstants.TABLENAME_USER_WATCH);
    }
    
    // These tables are loaded from static data files
    public static final Collection<String> DATAFILE_TABLES = new HashSet<String>();
    static {
        DATAFILE_TABLES.add(AuctionMarkConstants.TABLENAME_CATEGORY);
    }

    // ----------------------------------------------------------------
    // TIME PARAMETERS
    // ----------------------------------------------------------------
    
    /**
     * 1 sec in real time equals this value in the benchmark's virtual time in seconds
     */
    public static final long TIME_SCALE_FACTOR = 3600l; //  * 1000000l; // one hour
    
    /** How often to execute CLOSE_AUCTIONS in virtual milliseconds */
    public static final long INTERVAL_CLOSE_AUCTIONS    = 3600000l; // Check winning bid's frequency in millisecond
    
    /**
     * If the amount of time (in milliseconds) remaining for an item auction
     * is less than this parameter, then it will be added to a special queue
     * in the client. We will increase the likelihood that a users will bid on these
     * items as it gets closer to their end times
     */
    public static final long ENDING_SOON = 7200000l; // 10 hours
    
    public static final long SECONDS_IN_A_DAY = 24 * 60 * 60;
    public static final long MILLISECONDS_IN_A_DAY = SECONDS_IN_A_DAY * 1000;
    public static final long MICROSECONDS_IN_A_DAY = MILLISECONDS_IN_A_DAY * 1000;
    
    // ----------------------------------------------------------------
    // PROBABILITIES
    // ----------------------------------------------------------------
    
    /** The probability that a buyer will leave feedback for the seller (1-100)*/
    public static final int PROB_PURCHASE_BUYER_LEAVES_FEEDBACK = 75;
    /** The probability that a seller will leave feedback for the buyer (1-100)*/
    public static final int PROB_PURCHASE_SELLER_LEAVES_FEEDBACK = 80;
    
    public static final int PROB_GETUSERINFO_INCLUDE_FEEDBACK = 33;
    public static final int PROB_GETUSERINFO_INCLUDE_COMMENTS = 25;
    public static final int PROB_GETUSERINFO_INCLUDE_SELLER_ITEMS = 25;
    public static final int PROB_GETUSERINFO_INCLUDE_BUYER_ITEMS = 25;
    public static final int PROB_GETUSERINFO_INCLUDE_WATCHED_ITEMS = 50;
    
    public static final int PROB_UPDATEITEM_DELETE_ATTRIBUTE = 25;
    public static final int PROB_UPDATEITEM_ADD_ATTRIBUTE = -1; // 25;
    
    /** The probability that a buyer will not have enough money to purchase an item (1-100) */
    public static final int PROB_NEW_PURCHASE_NOT_ENOUGH_MONEY = 1;
    
    /** The probability that the NewBid txn will try to bid on a closed item (1-100) */
    public static final int PROB_NEWBID_CLOSED_ITEM = 5;
    
    /** The probability that a NewBid txn will target an item whose auction is ending soon (1-100) */
    public static final int PROB_NEWBID_ENDINGSOON_ITEM = 50;
}
