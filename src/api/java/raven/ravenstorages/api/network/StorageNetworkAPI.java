package raven.ravenstorages.api.network;

import raven.ravenstorages.api.network.query.request.Request;

import javax.annotation.Nonnull;

/**
 * 倉庫管理ネットワークのAPIを表すインターフェースです。
 *
 * <p>このインターフェースを通じてネットワークに対して検索、輸送命令を発行する事が出来ます。
 */
public interface StorageNetworkAPI {

    /**
     * このネットワークに対して検索、輸送命令を発行します。
     *
     * <p>ある時点で必要な倉庫に対する検索、輸送命令は1つのリクエストによって表現可能です。
     * 複数の命令を複数のRequestに分けるより1つのRequestで全ての要件を表現することが推奨されます。
     * <p>このメソッドの呼び出しは倉庫、クライアント双方に対して副作用を生成する可能性があります。
     * 検索要件の処理では倉庫に対する副作用は生みませんが、ハンドラメソッドの実行によりクライアントの指定した副作用を生成します。
     * 輸送要件の処理では倉庫の資源が増減し、ハンドラメソッドの実行により輸送元の指定した副作用を生成します。
     *
     * @param request このネットワークに対する検索、輸送要件
     */
    void query(@Nonnull Request request);
}
